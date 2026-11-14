package zoo.staff;

public class Veterinarian extends Employee {

    public Veterinarian(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void work() {
        System.out.println(name + " лечит животных.");
    }
}