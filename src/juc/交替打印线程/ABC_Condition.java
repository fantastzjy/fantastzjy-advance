package juc.交替打印线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock结合Condition
 */
public class ABC_Condition {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static int count = 0;
    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                System.err.println("a加锁");
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0) {//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        System.out.println("a睡觉觉" + i);
                        A.await(); // A释放lock锁   然后等待被唤醒
                        System.out.println("a被唤醒");
                    }
                    System.out.println("打印A");
                    count++;
                    B.signal(); // A执行完唤醒B线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.err.println("a释放锁");
                lock.unlock();
            }
        }
    }
    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                System.err.println("b加锁");
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1) {
                        System.out.println("b睡觉觉" + i);
                        B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                        System.out.println("b被唤醒");
                    }
                    System.out.println("打印B");
                    count++;
                    C.signal();// B执行完唤醒C线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.err.println("b释放锁");
                lock.unlock();
            }
        }
    }
    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                System.err.println("c加锁");
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2) {
                        System.out.println("c睡觉觉" + i);
                        C.await();// C释放lock锁，当前面B线程执行后会通过C.signal()唤醒该线程
                        System.out.println("c被唤醒");
                    }
                    System.out.println("打印C");
                    count++;
                    A.signal();// C执行完唤醒A线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.err.println("c释放锁");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();

    }

}
