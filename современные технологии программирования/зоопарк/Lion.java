package zoo.animals;

public class Lion extends Animal {

    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Лев рычит.");
    }

    @Override
    public void move() {
        System.out.println(name + " бегает.");
    }
}