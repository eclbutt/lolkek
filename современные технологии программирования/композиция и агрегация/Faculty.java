package university;

public class Faculty {

    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("Факультет: " + name);
    }
}