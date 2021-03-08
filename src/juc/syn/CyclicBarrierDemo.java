package juc.syn;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	private static final int NUMBER = 7;

	public static void main(String[] args) {

		//cyclicBarrier.await();   与减少计数器不同的是 足够的线程都处于await状态时 再去运行主线程   减少计数器是都减少完在去执行主线程
		CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
			System.out.println("集齐7颗龙珠就可以召唤神龙");
		});

		for (int i = 1; i <= 7; i++) {
			new Thread(() -> {
				try {

					Random random = new Random();
					try {
						Thread.sleep(random.nextInt(10) * 1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "\t 星龙珠被收集 ");
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}, String.valueOf(i)).start();
		}

	}
}