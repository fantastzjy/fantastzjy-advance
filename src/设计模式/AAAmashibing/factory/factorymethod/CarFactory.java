package 设计模式.AAAmashibing.factory.factorymethod;

public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
