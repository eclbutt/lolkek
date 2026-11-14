package zoo.animals;

public class Elephant extends Animal {

    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Слон трубит.");
    }

    @Override
    public void move() {
        System.out.println(name + " ходит.");
    }
}