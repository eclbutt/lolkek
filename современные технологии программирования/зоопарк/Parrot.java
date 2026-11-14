package zoo.animals;

public class Parrot extends Animal {

    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Попугай чирикает.");
    }

    @Override
    public void move() {
        System.out.println(name + " летает.");
    }
}