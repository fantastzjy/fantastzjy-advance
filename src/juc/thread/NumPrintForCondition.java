package juc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumPrintForCondition {

    public static int num = 0;

    Lock lock = new ReentrantLock();

    final Condition con0 = lock.newCondition();
    final Condition con1 = lock.newCondition();

    public void print0() {
        lock.lock();
        try {
            while (num == 0) {
                try {
                    con0.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 打印
            num--;
            System.err.println(Thread.currentThread().getName() + "打印    " + num);

            // 唤醒打印1的线程
            con1.signal();
        } finally {
            lock.unlock();
        }

    }

    public void print1() {
        lock.lock();

        try {

            while (num != 0) {
                try {
                    con1.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            // 打印
            num++;
            System.err.println(Thread.currentThread().getName() + "打印    " + num);

            // 唤醒打印1的线程
            con0.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        NumPrintForCondition testNumPrint = new NumPrintForCondition();

        // 打印0的线程1
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                testNumPrint.print0();
            }
        }, "打印0的线程1").start();
        // 打印0的线程2
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                testNumPrint.print0();
            }
        }, "打印0的线程2").start();

        // 打印1的线程1
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                testNumPrint.print1();
            }
        }, "打印1的线程1").start();

        // 打印1的线程2
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                testNumPrint.print1();
            }
        }, "打印1的线程2").start();

    }


}
