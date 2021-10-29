package 设计模式.factory.simple;

public class Main {
    public static void main(String[] args) {
        Moveable car = new Car();
        car.go();

        Moveable plane = new Plane();
        plane.go();
    }
}
