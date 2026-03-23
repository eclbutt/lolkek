public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        // Добавляем элементы
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Обход дерева
        System.out.println("Обход (in-order):");
        tree.inOrder();

        // Поиск
        System.out.println("Есть ли 40: " + tree.contains(40));
        System.out.println("Есть ли 90: " + tree.contains(90));
    }
}