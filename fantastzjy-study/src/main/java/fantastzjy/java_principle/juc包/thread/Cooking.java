package fantastzjy.java_principle.juc包.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cooking {

    public String status = "cut";
    Lock lock = new ReentrantLock();

    Condition cut = lock.newCondition();
    Condition cook = lock.newCondition();
    Condition giving = lock.newCondition();

    public void cut() {
        lock.lock();
        try {
            while (!status.equals("cut")) {
                try {
                    cut.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "开始切菜");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            status = "cook";
            cook.signal();
        } finally {
            lock.unlock();
        }
    }

    public void cook() {
        lock.lock();
        try {

            while (!status.equals("cook")) {
                try {
                    cook.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "开始炒菜");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            status = "giving";

            giving.signal();
        } finally {
            lock.unlock();
        }
    }

    public void giving() {

        lock.lock();
        try {

            while (!status.equals("giving")) {
                try {
                    giving.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "开始上菜");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            status = "cut";

            cut.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        System.out.println("餐馆开张了");

        Cooking cooking = new Cooking();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cooking.cut();
            }
        }, "张小切师傅").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cooking.cook();
            }
        }, "李小炒师傅").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cooking.giving();
                System.out.println("第" + (i + 1) + "道菜完成。。。");
            }
        }, "王小端师傅").start();

    }


}
