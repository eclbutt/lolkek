package layoutdemo;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {

        // Создание главного окна
        setTitle("Менеджеры компоновки Java");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Установка BorderLayout для JFrame
        setLayout(new BorderLayout(10, 10));

        // Верхняя панель
        JLabel title = new JLabel(
                "Демонстрация менеджеров компоновки",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 18));

        add(title, BorderLayout.NORTH);

        // Центральная панель
        JPanel centerPanel = new JPanel();

        // Установка FlowLayout для JPanel
        centerPanel.setLayout(
                new FlowLayout(FlowLayout.CENTER, 15, 15)
        );

        centerPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Панель с FlowLayout"
                )
        );

        // Создание кнопок
        JButton button1 = new JButton("Кнопка 1");
        JButton button2 = new JButton("Кнопка 2");
        JButton button3 = new JButton("Кнопка 3");
        JButton button4 = new JButton("Кнопка 4");
        JButton button5 = new JButton("Кнопка 5");

        // Добавление кнопок на панель
        centerPanel.add(button1);
        centerPanel.add(button2);
        centerPanel.add(button3);
        centerPanel.add(button4);
        centerPanel.add(button5);

        // Размещение панели в центре JFrame
        add(centerPanel, BorderLayout.CENTER);

        // Нижняя панель
        JLabel info = new JLabel(
                "JFrame: BorderLayout | JPanel: FlowLayout",
                SwingConstants.CENTER
        );

        add(info, BorderLayout.SOUTH);

        // Отображение окна
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}