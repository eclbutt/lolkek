package zoo.animals;

import zoo.interfaces.Feedable;
import zoo.interfaces.Movable;

public abstract class Animal implements Feedable, Movable {

    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
    }

    @Override
    public void eat() {
        System.out.println(name + " ест.");
    }
}