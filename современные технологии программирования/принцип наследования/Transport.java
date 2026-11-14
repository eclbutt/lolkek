package transport;

public class Transport {

    protected String brand;
    protected int speed;

    public Transport(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void move() {
        System.out.println(brand + " передвигается.");
    }

    public void showInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Скорость: " + speed + " км/ч");
    }
}