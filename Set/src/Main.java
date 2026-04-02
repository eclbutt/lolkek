public class Main {
    public static void main(String[] args) {

        Set set = new Set(5);

        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.insert(2); // повтор

        set.show();

        set.delete(2);

        set.show();

        System.out.println("Есть 3: " + set.exists(3));
        System.out.println("Есть 10: " + set.exists(10));
    }
}