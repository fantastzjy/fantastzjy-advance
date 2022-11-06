package fantastzjy.java_design_patterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * 策略模式
 */
public class Strategy {
    public static void main(String[] args) {
        //Cat[] cat ={new Cat(5,1),new Cat(6,3),new Cat(1,0)};
        Dog[] dog = {new Dog(5, 1), new Dog(6, 3), new Dog(1, 0)};

        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(dog, new DogWeightComparator());
        System.out.println(Arrays.toString(dog));
    }
}

@FunctionalInterface  //函数式接口  只有一个方法 可以不写  另外  里面可以写default方法的实现
interface Comparator<T> {
    int compare(T o1, T o2);
}

class Sorter<T> {
    public void sort(T[] arr, Comparator<T> compartor) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (compartor.compare(arr[min], arr[j]) == 1) min = j;
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

class DogWeightComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.weight < o2.weight ? -1 : o1.weight > o2.weight ? 1 : 0;
    }
}

class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.weight < o2.weight ? -1 : o1.weight > o2.weight ? 1 : 0;
    }
}

@Data
@AllArgsConstructor
class Cat {
    int weight;
    int height;
}

@Data
@AllArgsConstructor
class Dog {
    int weight;
    int height;
}