package 设计模式.马士兵.strategy;

public class Cat implements java.lang.Comparable<Cat> {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat c) {

        if(this.weight < c.weight) return -1;
        else if(this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
