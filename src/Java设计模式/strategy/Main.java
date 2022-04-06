package Java设计模式.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Cat[] cat ={new Cat(5,1),new Cat(6,3),new Cat(1,0)};
        Dog[] dog ={new Dog(5,1),new Dog(6,3),new Dog(1,0)};

        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(dog, new DogWeightComparator());
        System.out.println(Arrays.toString(dog));

    }
}
