package transport;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("Toyota", 180);

        Motorcycle motorcycle =
                new Motorcycle("Honda", 150);

        System.out.println("--- Автомобиль ---");
        car.showInfo();
        car.move();
        car.honk();

        System.out.println("\n--- Мотоцикл ---");
        motorcycle.showInfo();
        motorcycle.move();
        motorcycle.wheelie();
    }
}