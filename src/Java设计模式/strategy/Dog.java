package Java设计模式.strategy;

public class Dog {
    int weight;
    int height;

    public Dog(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
