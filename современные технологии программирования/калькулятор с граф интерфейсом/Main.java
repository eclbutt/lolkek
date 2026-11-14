package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    private JTextField display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean newNumber = true;

    public Main() {

        // Настройки окна
        setTitle("Калькулятор");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Поле для отображения чисел
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        add(display, BorderLayout.NORTH);

        // Панель с кнопками
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        // Создание кнопок
        for (String text : buttons) {

            JButton button = new JButton(text);

            button.setFont(new Font("Arial", Font.BOLD, 22));
            button.addActionListener(this);

            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // Если нажата цифра
        if (command.matches("[0-9]")) {

            if (newNumber) {
                display.setText(command);
                newNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        }

        // Очистка
        else if (command.equals("C")) {

            display.setText("0");
            firstNumber = 0;
            operator = "";
            newNumber = true;
        }

        // Выбор операции
        else if (command.matches("[+\\-*/]")) {

            firstNumber = Double.parseDouble(display.getText());
            operator = command;
            newNumber = true;
        }

        // Вычисление результата
        else if (command.equals("=")) {

            if (operator.isEmpty()) {
                return;
            }

            double secondNumber =
                    Double.parseDouble(display.getText());

            double result = 0;

            switch (operator) {

                case "+":
                    result = firstNumber + secondNumber;
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    break;

                case "*":
                    result = firstNumber * secondNumber;
                    break;

                case "/":

                    if (secondNumber == 0) {
                        display.setText("Ошибка");
                        operator = "";
                        newNumber = true;
                        return;
                    }

                    result = firstNumber / secondNumber;
                    break;
            }

            display.setText(String.valueOf(result));

            operator = "";
            newNumber = true;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}