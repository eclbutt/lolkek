package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;

    // Композиция
    private List<Faculty> faculties;

    // Агрегация
    private List<Teacher> teachers;

    public University(String name) {

        this.name = name;

        faculties = new ArrayList<>();
        teachers = new ArrayList<>();

        // Факультеты создаются внутри университета
        faculties.add(new Faculty("Информационных технологий"));
        faculties.add(new Faculty("Экономический"));
        faculties.add(new Faculty("Гуманитарный"));
    }

    // Добавление преподавателя
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void showInfo() {

        System.out.println("Университет: " + name);

        System.out.println("\n--- Факультеты ---");

        for (Faculty faculty : faculties) {
            faculty.showInfo();
        }

        System.out.println("\n--- Преподаватели ---");

        for (Teacher teacher : teachers) {
            teacher.showInfo();
        }
    }
}