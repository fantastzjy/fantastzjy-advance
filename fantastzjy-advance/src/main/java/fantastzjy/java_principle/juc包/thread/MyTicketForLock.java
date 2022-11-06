package fantastzjy.java_principle.juc包.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTicketForLock {

    public static int num = 10;

    Lock lock = new ReentrantLock();

    public void sale() {


        lock.lock();
        System.out.println(Thread.currentThread().getName() + "，手动上锁");

        try {
            num--;
            System.out.println(Thread.currentThread().getName() + "买了一张票，剩余票数" + num);
        } finally {

            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "，手动解锁");
        }
    }


    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        MyTicketForLock.num = num;
    }


    public static void main(String[] args) {

        MyTicketForLock myTicket = new MyTicketForLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                myTicket.sale();
            }, "消费者lock锁测试线程" + i).start();// 执行卖票任务
        }

    }
}
