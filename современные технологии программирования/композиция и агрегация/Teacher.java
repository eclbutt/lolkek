package university;

public class Teacher {

    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void showInfo() {
        System.out.println(
                "Преподаватель: " + name +
                        ", предмет: " + subject
        );
    }
}