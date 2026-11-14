package files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FileProcessor {

    // Сжатие файла
    public static void compress(String input, String output)
            throws IOException {

        List<String> lines = Files.readAllLines(
                Paths.get(input), StandardCharsets.UTF_8
        );

        // Сохраняем строки и количество их повторений
        Map<String, Integer> uniqueLines = new LinkedHashMap<>();

        for (String line : lines) {
            uniqueLines.put(
                    line,
                    uniqueLines.getOrDefault(line, 0) + 1
            );
        }

        int deleted = 0;

        // Запись сжатого файла
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(output), StandardCharsets.UTF_8)) {

            for (Map.Entry<String, Integer> entry
                    : uniqueLines.entrySet()) {

                int count = entry.getValue();

                deleted += count - 1;

                // Кодируем строку, чтобы разделители
                // внутри текста не мешали чтению
                String encoded = Base64.getEncoder().encodeToString(
                        entry.getKey().getBytes(StandardCharsets.UTF_8)
                );

                writer.write(count + "\t" + encoded);
                writer.newLine();
            }

            writer.write("Удалено дублирующихся строк: " + deleted);
            writer.newLine();
        }

        System.out.println("Файл сжат.");
        System.out.println("Удалено дубликатов: " + deleted);
    }


    // Восстановление файла
    public static void restore(String input, String output)
            throws IOException {

        List<String> lines = Files.readAllLines(
                Paths.get(input), StandardCharsets.UTF_8
        );

        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(output), StandardCharsets.UTF_8)) {

            for (String line : lines) {

                // Пропускаем строку с информацией о дубликатах
                if (line.startsWith("Удалено дублирующихся строк: ")) {
                    continue;
                }

                String[] parts = line.split("\t", 2);

                int count = Integer.parseInt(parts[0]);

                String originalLine = new String(
                        Base64.getDecoder().decode(parts[1]),
                        StandardCharsets.UTF_8
                );

                // Возвращаем исходное количество строк
                for (int i = 0; i < count; i++) {
                    writer.write(originalLine);
                    writer.newLine();
                }
            }
        }

        System.out.println("Файл восстановлен.");
    }
}