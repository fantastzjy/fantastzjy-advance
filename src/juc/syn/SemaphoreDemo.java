package juc.syn;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟3个停车位
        Semaphore semaphore = new Semaphore(4);
        // 模拟6部汽车
        for (int i = 1; i <= 90; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();  //不指定就是默认一个许可证  可运行的线程数量为  4/1=4
                    semaphore.acquire(2);  //一次需要两个许可证   可运行的线程数量为  4/2=2

                    System.out.println(Thread.currentThread().getName() + "\t 抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                    System.out.println(Thread.currentThread().getName() + "\t------- 离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    //semaphore.release(2);
                }
            }, String.valueOf(i)).start();
        }

    }
}