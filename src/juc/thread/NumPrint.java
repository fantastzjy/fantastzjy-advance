package juc.thread;

public class NumPrint {

	public static int num = 0;

	public synchronized void print0() {

		while  (num == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 打印
		num++;
		System.out.println(Thread.currentThread().getName()+"打印    "+num);

		// 唤醒打印1的线程
		this.notifyAll();
	}

}
