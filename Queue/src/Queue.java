/**
 * Класс Queue реализует структуру данных "Очередь" (FIFO).
 * Первый добавленный элемент извлекается первым.
 */
public class Queue<T> {

    private T[] elements; // массив для хранения данных
    private int front;    // индекс начала очереди
    private int rear;     // индекс конца очереди
    private int size;     // текущее количество элементов
    private int capacity; // максимальный размер

    /**
     * Конструктор очереди
     */
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Добавление элемента в конец очереди
     */
    public void enqueue(T value) {
        // Проверка переполнения
        if (isFull()) {
            System.out.println("Очередь переполнена!");
            return;
        }

        rear = (rear + 1) % capacity; // циклический переход
        elements[rear] = value;
        size++;
    }

    /**
     * Удаление элемента из начала очереди
     */
    public T dequeue() {
        // Проверка на пустоту
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return null;
        }

        T value = elements[front];
        front = (front + 1) % capacity; // сдвиг начала
        size--;

        return value;
    }

    /**
     * Просмотр первого элемента без удаления
     */
    public T peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return null;
        }

        return elements[front];
    }

    /**
     * Проверка: пуста ли очередь
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверка: заполнена ли очередь
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Вывод всех элементов очереди
     */
    public void printQueue() {
        System.out.println("Элементы очереди:");

        // Проходим по всем элементам с учётом цикличности
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println(elements[index]);
        }
    }
}