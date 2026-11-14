import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== КАЛЬКУЛЯТОР СЛОЖНЫХ ПРОЦЕНТОВ ===");
        System.out.println("1. Рассчитать итоговую сумму");
        System.out.println("2. Рассчитать необходимый процент");

        System.out.print("Выберите действие: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                // Расчет сложного процента

                System.out.print("Введите начальное число: ");
                double number = scanner.nextDouble();

                System.out.print("Введите процент: ");
                double percent = scanner.nextDouble();

                System.out.print("Введите количество периодов: ");
                int periods = scanner.nextInt();

                if (number < 0 || periods < 0 || percent <= -100) {
                    System.out.println("Ошибка! Некорректные данные.");
                    break;
                }

                double result = number *
                        Math.pow(1 + percent / 100, periods);

                System.out.println("Итоговое число: " + result);
                break;

            case 2:
                // Обратный расчет процента

                System.out.print("Введите Число 1: ");
                double number1 = scanner.nextDouble();

                System.out.print("Введите Число 2: ");
                double number2 = scanner.nextDouble();

                System.out.print("Введите количество периодов: ");
                int n = scanner.nextInt();

                if (number1 <= 0 || number2 <= 0 || n <= 0) {
                    System.out.println("Ошибка! Числа и количество периодов должны быть положительными.");
                    break;
                }

                double requiredPercent =
                        (Math.pow(number2 / number1, 1.0 / n) - 1) * 100;

                System.out.println(
                        "Необходимый процент: " + requiredPercent + "%"
                );
                break;

            default:
                System.out.println("Ошибка! Такого действия нет.");
        }

        scanner.close();
    }
}