package java原理相关.juc包.syn;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 一个线程写入, 100个线程读取
 */
public class ReadWriteLockDemo {

    static class MyQueue {
        private Object obj;
        private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


        /***
         * 加写锁
         * 修改屏幕信息
         */
        public void writeObj(Object obj) {
            rwLock.writeLock().lock();
            try {
                this.obj = obj;
                System.out.println(Thread.currentThread().getName() + "writeThread: \t" + obj);
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rwLock.writeLock().unlock();
            }
        }

        /***
         * 加读锁
         * 读取屏幕信息
         */
        public void readObj() {
            rwLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " \t" + obj);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rwLock.readLock().unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue();

        //用一个对象去调用方法 保证了用同一把锁

        // 以为老师调用写操作，修改屏幕信息
        new Thread(() -> {
            myQueue.writeObj("下课啦");
        }, "徐老师").start();

        new Thread(() -> {
            myQueue.writeObj("没下课啦，继续上课");
        }, "李老师").start();

        // 100同学调用读操作，读取屏幕信息
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                myQueue.readObj();
            }, "同学小" + i).start();
        }
    }
}
