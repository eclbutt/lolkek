package zoo.staff;

public class Keeper extends Employee {

    public Keeper(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void work() {
        System.out.println(name + " ухаживает за животными.");
    }
}