package zoo.enclosures;

import zoo.animals.Animal;
import java.util.ArrayList;

public class Enclosure {

    private String name;
    private int capacity;
    private ArrayList<Animal> animals;

    public Enclosure(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
            System.out.println(
                    animal.getName() + " добавлен в вольер."
            );
        } else {
            System.out.println("Вольер заполнен!");
        }
    }

    public void showAnimals() {
        System.out.println("Вольер: " + name);

        for (Animal animal : animals) {
            animal.showInfo();
        }
    }
}