package fantastzjy.java_design_patterns.factory.simpleFactory;

/**
 * 简单工厂
 */
public class Simple {
    public static void main(String[] args) {
        Moveable car = new Car();
        car.go();

        Moveable plane = new Plane();
        plane.go();
    }
}

interface Moveable {
    void go();
}

class Car implements Moveable {
    @Override
    public void go() {
        System.out.println("小汽车 呜呀呜呀呜~~~~~~~~~");
    }
}

class Plane implements Moveable {
    @Override
    public void go() {
        System.out.println("小飞机 飞呀飞呀飞~~~~~~~~~");
    }
}