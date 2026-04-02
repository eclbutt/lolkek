import java.util.Random;

/**
 * Сравнение двух алгоритмов:
 * Selection Sort и Merge Sort
 */
public class Main {

    public static void main(String[] args) {

        int small = 1000;
        int big = 100000;

        int[] arrSmallA = createArray(small);
        int[] arrSmallB = arrSmallA.clone();

        int[] arrBigA = createArray(big);
        int[] arrBigB = arrBigA.clone();

        // --- Маленький массив ---
        System.out.println("Маленький массив:");

        long t1 = System.nanoTime();
        selectionSort(arrSmallA);
        long t2 = System.nanoTime();
        System.out.println("Selection Sort: " + (t2 - t1) + " ns");

        t1 = System.nanoTime();
        mergeSort(arrSmallB, 0, arrSmallB.length - 1);
        t2 = System.nanoTime();
        System.out.println("Merge Sort: " + (t2 - t1) + " ns");

        // --- Большой массив ---
        System.out.println("\nБольшой массив:");

        t1 = System.nanoTime();
        selectionSort(arrBigA);
        t2 = System.nanoTime();
        System.out.println("Selection Sort: " + (t2 - t1) + " ns");

        t1 = System.nanoTime();
        mergeSort(arrBigB, 0, arrBigB.length - 1);
        t2 = System.nanoTime();
        System.out.println("Merge Sort: " + (t2 - t1) + " ns");
    }

    /**
     * Создание массива со случайными числами
     */
    public static int[] createArray(int size) {
        Random random = new Random();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(10000);
        }

        return result;
    }

    /**
     * Сортировка выбором (Selection Sort)
     * На каждой итерации ищем минимальный элемент
     */
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            // Поиск минимального элемента
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Обмен элементов
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Сортировка слиянием (Merge Sort)
     */
    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) return;

        int mid = (left + right) / 2;

        // Делим массив
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Сливаем части
        merge(arr, left, mid, right);
    }

    /**
     * Слияние двух отсортированных частей
     */
    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // Сравнение элементов двух частей
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Добавляем оставшиеся элементы
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Копируем обратно в основной массив
        for (int n = 0; n < temp.length; n++) {
            arr[left + n] = temp[n];
        }
    }
}