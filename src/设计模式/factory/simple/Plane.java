package 设计模式.factory.simple;

public class Plane implements Moveable {
    @Override
    public void go() {
        System.out.println("小飞机 飞呀飞呀飞~~~~~~~~~");
    }
}
