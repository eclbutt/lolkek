/**
 * Класс List реализует односвязный список.
 * Каждый элемент содержит данные и ссылку на следующий.
 */
public class List {

    /**
     * Внутренний элемент списка
     */
    private class Item {
        int data;
        Item nextItem;

        Item(int data) {
            this.data = data;
        }
    }

    private Item first; // начало списка

    /**
     * Добавление элемента в список (в конец)
     */
    public void insert(int value) {

        Item element = new Item(value);

        // Если список пуст — элемент становится первым
        if (first == null) {
            first = element;
            return;
        }

        Item temp = first;

        // Идём до последнего элемента
        while (temp.nextItem != null) {
            temp = temp.nextItem;
        }

        temp.nextItem = element;
    }

    /**
     * Удаление элемента по значению
     */
    public void delete(int value) {

        if (first == null) return;

        // Удаление первого элемента
        if (first.data == value) {
            first = first.nextItem;
            return;
        }

        Item temp = first;

        // Поиск элемента перед удаляемым
        while (temp.nextItem != null && temp.nextItem.data != value) {
            temp = temp.nextItem;
        }

        // Если нашли — удаляем
        if (temp.nextItem != null) {
            temp.nextItem = temp.nextItem.nextItem;
        }
    }

    /**
     * Проверка наличия элемента
     */
    public boolean find(int value) {

        Item current = first;

        // Проход по всему списку
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.nextItem;
        }

        return false;
    }

    /**
     * Вывод списка
     */
    public void showAll() {

        Item current = first;

        System.out.print("List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.nextItem;
        }

        System.out.println("end");
    }
}