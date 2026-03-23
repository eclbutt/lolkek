/**
 * Класс BinaryTree реализует бинарное дерево поиска.
 * Для каждого узла: левый < корень < правый.
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    /**
     * Добавление элемента в дерево
     */
    public void insert(T value) {
        root = insertRec(root, value);
    }

    /**
     * Рекурсивная вставка элемента
     */
    private Node<T> insertRec(Node<T> current, T value) {

        // Если место найдено — создаем новый узел
        if (current == null) {
            return new Node<>(value);
        }

        // Сравнение и выбор направления
        if (value.compareTo(current.value) < 0) {
            current.left = insertRec(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRec(current.right, value);
        }

        return current;
    }

    /**
     * Обход дерева (in-order)
     * Выводит элементы в отсортированном порядке
     */
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> node) {
        if (node != null) {

            // Сначала левое поддерево
            inOrderRec(node.left);

            // Затем текущий узел
            System.out.print(node.value + " ");

            // Потом правое поддерево
            inOrderRec(node.right);
        }
    }

    /**
     * Поиск элемента в дереве
     */
    public boolean contains(T value) {
        return containsRec(root, value);
    }

    private boolean containsRec(Node<T> node, T value) {

        // Базовые случаи: не найден или найден
        if (node == null) return false;
        if (value.equals(node.value)) return true;

        // Переход в нужную ветку
        if (value.compareTo(node.value) < 0) {
            return containsRec(node.left, value);
        } else {
            return containsRec(node.right, value);
        }
    }
}