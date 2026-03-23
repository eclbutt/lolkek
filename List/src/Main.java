public class Main {
    public static void main(String[] args) {

        List list = new List();

        list.insert(5);
        list.insert(15);
        list.insert(25);

        list.showAll();

        list.delete(15);

        list.showAll();

        System.out.println("Найдено 25: " + list.find(25));
        System.out.println("Найдено 100: " + list.find(100));
    }
}