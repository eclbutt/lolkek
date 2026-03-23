public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(40);
        tree.insert(25);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);

        System.out.println("Дерево:");
        tree.show();

        System.out.println("Есть 30: " + tree.search(30));
        System.out.println("Есть 99: " + tree.search(99));
    }
}