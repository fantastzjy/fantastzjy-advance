package Java原理相关.juc包.交替打印线程;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Thread {

    private static ReentrantLock lock = new ReentrantLock();
    static int state = 0;

    static class PA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) { //i++) {  i只有在打印成功才增加
                lock.lock();
                try {
                    while (state % 3 == 0) {
                        System.out.println("A");
                        state++;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) { // i++) {
                lock.lock();
                try {
                    while (state % 3 == 1) {
                        System.out.println("B");
                        state++;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) { // i++) {
                lock.lock();
                try {
                    while (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        new PA().start();
        new PB().start();
        new PC().start();
    }


}
