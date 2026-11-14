package zoo.staff;

public abstract class Employee {

    protected String name;
    protected int experience;

    public Employee(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public abstract void work();

    public void showInfo() {
        System.out.println("Имя сотрудника: " + name);
        System.out.println("Опыт работы: " + experience);
    }
}