/**
 * Узел бинарного дерева.
 * Хранит значение и ссылки на потомков.
 */
public class Node<T> {

    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}