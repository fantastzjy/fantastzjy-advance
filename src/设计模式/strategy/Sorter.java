package 设计模式.strategy;

public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> compartor) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (compartor.compare(arr[min], arr[j]) == 1) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private void swap(T[] arr, int i, int min) {
        T temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
