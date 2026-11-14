import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите год: ");

            int year = scanner.nextInt();

            if (year <= 0) {
                throw new IllegalArgumentException(
                        "Год должен быть положительным числом!"
                );
            }

            if (year % 400 == 0 ||
                    (year % 4 == 0 && year % 100 != 0)) {

                System.out.println(year + " год является високосным.");

            } else {

                System.out.println(year + " год не является високосным.");
            }

        } catch (java.util.InputMismatchException e) {

            System.out.println("Ошибка! Необходимо ввести целое число.");

        } catch (IllegalArgumentException e) {

            System.out.println("Ошибка! " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}