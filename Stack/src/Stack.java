/**
 * Класс Stack реализует структуру данных "Стек" (LIFO).
 * Последний добавленный элемент извлекается первым.
 */
public class Stack<T> {

    private T[] elements;   // массив для хранения элементов
    private int size;       // текущее количество элементов
    private int capacity;   // максимальный размер стека

    /**
     * Конструктор: создаёт стек заданного размера
     */
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        elements = (T[]) new Object[capacity];
    }

    /**
     * Добавление элемента на вершину стека
     */
    public void push(T value) {
        // Проверка переполнения
        if (isFull()) {
            System.out.println("Стек переполнен!");
            return;
        }
        elements[size++] = value;
    }

    /**
     * Удаление и возврат верхнего элемента
     */
    public T pop() {
        // Проверка на пустоту
        if (isEmpty()) {
            System.out.println("Стек пуст!");
            return null;
        }
        return elements[--size];
    }

    /**
     * Получение верхнего элемента без удаления
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("Стек пуст!");
            return null;
        }
        return elements[size - 1];
    }

    /**
     * Проверка: пуст ли стек
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверка: заполнен ли стек
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Вывод всех элементов стека
     */
    public void printStack() {
        System.out.println("Элементы стека:");

        // Проходим по массиву и выводим элементы
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }
}