package java原理相关.juc包.交替打印线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁方法
 * 1、基本思路
 * 通过ReentrantLock我们可以很方便的进行显式的锁操作，即获取锁和释放锁，
 * 对于同一个对象锁而言，统一时刻只可能有一个线程拿到了这个锁，此时其他线程通过lock.lock()来获取对象锁时都会被阻塞，
 * 直到这个线程通过lock.unlock()操作释放这个锁后，其他线程才能拿到这个锁。
 */
public class ABC_Lock {
    //静态的，保证同一时刻只有一个锁   ReentrantLock默认为非公平锁   传入true才为公平锁
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    //lock是静态的，所以只有一个能获得lock锁 三个线程 都是在for循环中循环去’非公平‘抢占锁
                    lock.lock();  //下面说的不对吧 都是只起到一个判断作用！！！！！！！  经测试  if效果是一样的
                    while (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        //System.out.println("C"+i);
                        System.out.println("C" + i);
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
