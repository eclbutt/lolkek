package university;

public class Main {

    public static void main(String[] args) {

        // Создание преподавателей отдельно
        Teacher teacher1 =
                new Teacher("Иван Иванов", "Программирование");

        Teacher teacher2 =
                new Teacher("Анна Петрова", "Математика");

        // Создание университета
        University university =
                new University("Государственный университет");

        // Добавление преподавателей
        university.addTeacher(teacher1);
        university.addTeacher(teacher2);

        // Вывод информации
        university.showInfo();

        System.out.println("\n--- Проверка агрегации ---");

        // Преподаватель существует независимо от университета
        teacher1.showInfo();
    }
}