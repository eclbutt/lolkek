/**
 * Класс Tree реализует бинарное дерево поиска.
 * Каждый узел имеет максимум два потомка.
 */
public class Tree {

    /**
     * Внутренний класс узла
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    /**
     * Добавление элемента
     */
    public void insert(int value) {
        root = insertNode(root, value);
    }

    /**
     * Рекурсивное добавление
     */
    private Node insertNode(Node current, int value) {

        // Если нашли пустое место — создаём узел
        if (current == null) {
            return new Node(value);
        }

        // Определяем направление вставки
        if (value < current.value) {
            current.left = insertNode(current.left, value);
        } else if (value > current.value) {
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    /**
     * Поиск элемента
     */
    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node current, int value) {

        if (current == null) return false;

        if (current.value == value) return true;

        // Идём влево или вправо
        if (value < current.value) {
            return searchNode(current.left, value);
        } else {
            return searchNode(current.right, value);
        }
    }

    /**
     * Обход дерева (in-order)
     */
    public void show() {
        showTree(root);
        System.out.println();
    }

    private void showTree(Node node) {

        if (node == null) return;

        // Левый → корень → правый
        showTree(node.left);
        System.out.print(node.value + " ");
        showTree(node.right);
    }
}