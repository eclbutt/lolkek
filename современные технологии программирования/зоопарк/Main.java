package zoo;

import zoo.animals.*;
import zoo.staff.*;
import zoo.enclosures.*;

public class Main {

    public static void main(String[] args) {

        // Создание животных
        Lion lion = new Lion("Симба", 5);
        Elephant elephant = new Elephant("Дамбо", 10);
        Parrot parrot = new Parrot("Кеша", 2);

        // Создание сотрудников
        Keeper keeper = new Keeper("Иван", 3);
        Veterinarian veterinarian =
                new Veterinarian("Анна", 7);

        // Создание вольера
        Enclosure enclosure =
                new Enclosure("Главный вольер", 5);

        // Добавление животных
        enclosure.addAnimal(lion);
        enclosure.addAnimal(elephant);
        enclosure.addAnimal(parrot);

        // Вывод информации
        System.out.println("\n--- Животные зоопарка ---");
        enclosure.showAnimals();

        // Звуки животных
        System.out.println("\n--- Звуки животных ---");
        lion.makeSound();
        elephant.makeSound();
        parrot.makeSound();

        // Передвижение животных
        System.out.println("\n--- Передвижение ---");
        lion.move();
        elephant.move();
        parrot.move();

        // Кормление
        System.out.println("\n--- Кормление ---");
        lion.eat();
        elephant.eat();
        parrot.eat();

        // Работа сотрудников
        System.out.println("\n--- Сотрудники ---");
        keeper.showInfo();
        keeper.work();

        veterinarian.showInfo();
        veterinarian.work();
    }
}