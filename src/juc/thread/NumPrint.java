package juc.thread;

public class NumPrint {

	public static int num = 0;

	public synchronized void print0() {

		while  (num == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 打印
		num--;
		System.out.println(Thread.currentThread().getName()+"打印    "+num);

		// 唤醒打印1的线程
		this.notifyAll();

	}

	public synchronized void print1() {

		while  (num != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 打印
		num++;
		System.out.println(Thread.currentThread().getName() + "打印    " + num);

		// 唤醒打印1的线程
		this.notifyAll();
	}

	public static void main(String[] args) {

		NumPrint testNumPrint = new NumPrint();

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
