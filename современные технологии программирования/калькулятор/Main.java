import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение (например, 2 * 6.5):");
        String expression = scanner.nextLine();

        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            System.out.println("Ошибка! Неверный формат выражения.");
            return;
        }

        double num1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double num2 = Double.parseDouble(parts[2]);

        double result;

        switch (operator) {

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    System.out.println("Ошибка! Деление на ноль невозможно.");
                    return;
                }
                result = num1 / num2;
                break;

            default:
                System.out.println("Ошибка! Неизвестная операция.");
                return;
        }

        System.out.println("Результат: " + result);

        scanner.close();
    }
}