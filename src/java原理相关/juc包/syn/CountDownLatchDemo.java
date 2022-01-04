package java原理相关.juc包.syn;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(10);

		System.out.println("负责锁门的同学，在观察");

		for (int i = 0; i < 10; i++) {

			new Thread(() -> {
				Random random = new Random();
				try {
					Thread.sleep(random.nextInt(10) * 1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("同学小" + Thread.currentThread().getName() + "离开了教室");
				countDownLatch.countDown();
                System.out.println("同学小" + Thread.currentThread().getName() + "继续");
			}, i + "").start();
		}

		//使线程发生阻塞
		countDownLatch.await();

		System.out.println("负责锁门的同学，把门锁好关灯离开");
	}

}
