package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Main extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public Main() {

        // Настройка окна
        setTitle("Текстовый редактор");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание текстового поля
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Добавление полосы прокрутки
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Выбор файлов
        fileChooser = new JFileChooser();

        // Создание меню
        createMenu();

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

        // Обработка нажатий
        newItem.addActionListener(e -> newFile());
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        // Добавление пунктов в меню
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
        setTitle("Текстовый редактор");
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

                setTitle("Текстовый редактор - "
                        + file.getName());

                JOptionPane.showMessageDialog(
                        this,
                        "Файл успешно открыт!",
                        "Открытие файла",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ошибка при открытии файла: "
                                + e.getMessage(),
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

                setTitle("Текстовый редактор - "
                        + file.getName());

                JOptionPane.showMessageDialog(
                        this,
                        "Файл успешно сохранён!",
                        "Сохранение файла",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (IOException e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ошибка при сохранении файла: "
                                + e.getMessage(),
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}