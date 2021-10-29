package 设计模式.observer.v8;


import java.util.ArrayList;
import java.util.List;

/**
 * 很多时候，观察者需要根据事件的具体情况来处理
 * 所以大多数时候，处理事件的时候需要事件的源对象
 * 事件也可以形成继承体系
 * 与V7相比  这里增加了Event的继承体系
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
        WeakUpEvent event = new WeakUpEvent(System.currentTimeMillis(), "床上", this);
        for (Observer observer : observers) {
            observer.actionOnWeakUp(event);
        }
    }
}

//所有的事件都有getSource 这里模拟jdk的Event
abstract class Event<T> {
    abstract T getSource();
}

class WeakUpEvent extends Event<Child> {
    long timestamp;
    String loc;
    Child source;

    public WeakUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer {
    void actionOnWeakUp(WeakUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("观察者1：爸爸喂你 Dad feed");
    }

    @Override
    public void actionOnWeakUp(WeakUpEvent event) {
        feed();
        //事件继承了 event之后可以获取到具体的事件源
        System.out.println("孩子正在哭吗？" + event.getSource().isCry());
        System.out.println("孩子在哪哭？" + event.loc);
    }
}

class Mum implements Observer {

    public void hug() {
        System.out.println("观察者2：妈妈抱你 Mum hug");
    }

    @Override
    public void actionOnWeakUp(WeakUpEvent event) {
        hug();
    }
}

public class V8 {
    public static void main(String[] args) {
        new Child().weakUp();
    }
}
