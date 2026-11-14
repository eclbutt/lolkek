package transport;

public class Car extends Transport {

    public Car(String brand, int speed) {
        super(brand, speed);
    }

    public void honk() {
        System.out.println(brand + " сигналит.");
    }
}