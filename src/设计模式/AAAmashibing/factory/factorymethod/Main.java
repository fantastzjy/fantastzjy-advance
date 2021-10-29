package 设计模式.AAAmashibing.factory.factorymethod;

public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();
    }
}
