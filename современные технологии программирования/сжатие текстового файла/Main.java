package files;

import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== РАБОТА С ФАЙЛАМИ ===");
        System.out.println("1. Сжать файл");
        System.out.println("2. Восстановить файл");

        System.out.print("Выберите действие: ");

        try {
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    FileProcessor.compress(
                            "input.txt",
                            "compressed.txt"
                    );
                    break;

                case 2:
                    FileProcessor.restore(
                            "compressed.txt",
                            "restored.txt"
                    );
                    break;

                default:
                    System.out.println("Неверный выбор!");
            }

        } catch (IOException e) {
            System.out.println(
                    "Ошибка при работе с файлом: " + e.getMessage()
            );

        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата данных!");

        } finally {
            scanner.close();
        }
    }
}