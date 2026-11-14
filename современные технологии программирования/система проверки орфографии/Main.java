package editor;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    // Словарь неправильных и правильных слов
    private final Map<String, String> dictionary = new HashMap<>();

    public Main() {

        setTitle("Текстовый редактор с автозаменой");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Заполнение словаря
        dictionary.put("превет", "привет");
        dictionary.put("спосибо", "спасибо");
        dictionary.put("пажалуйста", "пожалуйста");
        dictionary.put("здраствуйте", "здравствуйте");
        dictionary.put("извените", "извините");

        // Создание текстового поля
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        fileChooser = new JFileChooser();

        createMenu();

        // Отслеживание ввода текста
        textArea.getDocument().addDocumentListener(
                new DocumentListener() {

                    @Override
                    public void insertUpdate(DocumentEvent e) {

                        int position = e.getOffset();

                        try {
                            String inserted = e.getDocument()
                                    .getText(position, e.getLength());

                            // Запуск проверки после пробела
                            if (inserted.contains(" ")) {
                                checkWordInThread();
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                    }
                }
        );

        setVisible(true);
    }

    // Создание меню
    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");

        JMenuItem newItem = new JMenuItem("Создать");
        JMenuItem openItem = new JMenuItem("Открыть");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выход");

        newItem.addActionListener(e -> newFile());
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    // Создание нового документа
    private void newFile() {
        textArea.setText("");
        setTitle("Текстовый редактор с автозаменой");
    }

    // Открытие файла
    private void openFile() {

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try {
                String content = Files.readString(
                        file.toPath(),
                        StandardCharsets.UTF_8
                );

                textArea.setText(content);

                setTitle("Текстовый редактор - " + file.getName());

                JOptionPane.showMessageDialog(
                        this,
                        "Файл успешно открыт!"
                );

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ошибка открытия файла: " + e.getMessage(),
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // Сохранение файла
    private void saveFile() {

        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            try {
                Files.writeString(
                        file.toPath(),
                        textArea.getText(),
                        StandardCharsets.UTF_8
                );

                setTitle("Текстовый редактор - " + file.getName());

                JOptionPane.showMessageDialog(
                        this,
                        "Файл успешно сохранён!"
                );

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ошибка сохранения файла: " + e.getMessage(),
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // Проверка слова в отдельном потоке
    private void checkWordInThread() {

        // Получаем текст и позицию курсора в основном потоке Swing
        String text = textArea.getText();
        int caretPosition = textArea.getCaretPosition();

        // Проверяем, что перед курсором находится пробел
        if (caretPosition < 1 ||
                text.charAt(caretPosition - 1) != ' ') {
            return;
        }

        // Определяем границы предыдущего слова
        int end = caretPosition - 1;
        int start = end;

        while (start > 0 &&
                Character.isLetter(text.charAt(start - 1))) {
            start--;
        }

        if (start == end) {
            return;
        }

        String word = text.substring(start, end);

        // Создаём отдельный поток
        Thread thread = new Thread(() -> {

            // Проверяем слово по словарю
            String correctWord = dictionary.get(word.toLowerCase());

            if (correctWord != null) {

                // Изменения Swing-компонента выполняем в EDT
                SwingUtilities.invokeLater(() -> {

                    // Проверяем, что пользователь не изменил текст
                    if (textArea.getText().equals(text)) {

                        textArea.replaceRange(
                                correctWord,
                                start,
                                end
                        );

                    }
                });
            }

        });

        thread.start();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}