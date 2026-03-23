public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>(5);

        // Добавление элементов
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.printQueue();

        // Просмотр первого элемента
        System.out.println("Первый: " + queue.peek());

        // Удаление элемента
        System.out.println("Удален: " + queue.dequeue());

        queue.printQueue();
    }
}