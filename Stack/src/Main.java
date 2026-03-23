public class Main {
    public static void main(String[] args) {

        // Создаём стек вместимостью 5 элементов
        Stack<Integer> stack = new Stack<>(5);

        // Добавляем элементы
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Выводим стек
        stack.printStack();

        // Смотрим верхний элемент
        System.out.println("Вершина: " + stack.peek());

        // Удаляем элемент
        System.out.println("Удален: " + stack.pop());

        // Снова выводим стек
        stack.printStack();
    }
}