package transport;

public class Motorcycle extends Transport {

    public Motorcycle(String brand, int speed) {
        super(brand, speed);
    }

    public void wheelie() {
        System.out.println(brand + " выполняет трюк.");
    }
}