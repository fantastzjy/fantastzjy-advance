package 设计模式.observer.v7;


import java.util.ArrayList;
import java.util.List;

/**
 * 很多时候，观察者需要根据事件的具体情况来处理
 * 所以大多数时候，处理事件的时候需要事件的源对象
 */

//Child类 里面维护一个观察者集合 当触发事件时 构造创建一个事件类  让集合中的观察者去处理该时间

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    public boolean isCry() {
        return cry;
    }

    public void weakUp() {
        cry = true;
        //触发事件
        //this 将当前类当做事件源
        WeakUpEvent event = new WeakUpEvent(System.currentTimeMillis(), "床上", this);
        //观察者处理
        for (Observer observer : observers) {
            observer.actionOnWeakUp(event);
        }

    }

}

class WeakUpEvent {
    long timestamp;
    String loc;
    Child source;

    public WeakUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}

interface Observer {
    void actionOnWeakUp(WeakUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("Dad feed");
    }

    @Override
    public void actionOnWeakUp(WeakUpEvent event) {
        feed();
    }
}

class Mum implements Observer {

    public void hug() {
        System.out.println("Mum feed");
    }

    @Override
    public void actionOnWeakUp(WeakUpEvent event) {
        hug();
    }
}


public class v7 {
    public static void main(String[] args) {
        new Child().weakUp();
    }
}
