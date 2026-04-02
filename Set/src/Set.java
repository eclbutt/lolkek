/**
 * Класс Set реализует множество без повторяющихся элементов.
 * Используется массив фиксированного размера.
 */
public class Set {

    private int[] elements; // хранение значений
    private int count;      // количество элементов

    /**
     * Создание множества
     */
    public Set(int maxSize) {
        elements = new int[maxSize];
        count = 0;
    }

    /**
     * Добавление нового элемента
     */
    public void insert(int value) {

        // Проверяем, есть ли уже такой элемент
        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                System.out.println("Такой элемент уже есть");
                return;
            }
        }

        // Проверка на переполнение
        if (count >= elements.length) {
            System.out.println("Множество заполнено");
            return;
        }

        elements[count] = value;
        count++;
    }

    /**
     * Удаление элемента
     */
    public void delete(int value) {

        int index = -1;

        // Ищем элемент
        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                index = i;
                break;
            }
        }

        // Если нашли — сдвигаем элементы
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                elements[i] = elements[i + 1];
            }
            count--;
        }
    }

    /**
     * Проверка наличия элемента
     */
    public boolean exists(int value) {

        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Вывод всех элементов
     */
    public void show() {

        System.out.print("Set: ");

        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }
}