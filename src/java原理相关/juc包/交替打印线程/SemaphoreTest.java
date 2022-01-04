package java原理相关.juc包.交替打印线程;

import java.util.concurrent.Semaphore;

/**
 * 信号量不需要 状态量  来控制是否要打印
 * 直接在for循环中 获取 打印 释放 即可 获取不到会一直阻塞获取
 */
public class SemaphoreTest {

    private static Semaphore aaa = new Semaphore(1);
    private static Semaphore bbb = new Semaphore(0);
    private static Semaphore ccc = new Semaphore(0);

    //错误示例
    //static class PA extends Thread {
    //
    //    @Override
    //    public void run() {
    //        int state = 0;
    //        while (state < 10) {
    //            //if (state % 3 == 0) {
    //                try {
    //                    aaa.acquire(1);System.out.println("A");bbb.release();
    //                } catch (InterruptedException e) {
    //                    e.printStackTrace();
    //                }
    //
    //                state++;
    //
    //
    //            //}
    //        }
    //    }
    //}

    static class PA extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    aaa.acquire(1);
                    System.out.println("A");
                    bbb.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class PB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    bbb.acquire(1);
                    System.out.println("B");
                    ccc.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class PC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    ccc.acquire(1);
                    System.out.println("C");
                    aaa.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
