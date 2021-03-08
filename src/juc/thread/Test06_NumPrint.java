package juc.thread;

public class Test06_NumPrint {

	public static void main(String[] args) {
		
		NumPrint testNumPrint =new NumPrint();
		
		// 打印0的线程1
		new Thread(()->{
			for (int i = 0; i < 5; i++) {
				testNumPrint.print0();
			}
		},"打印0的线程1").start();
		// 打印0的线程2
		new Thread(()->{
			for (int i = 0; i < 5; i++) {
				testNumPrint.print0();
			}
		},"打印0的线程2").start();
		
		
		// 打印1的线程1
		new Thread(()->{
			for (int i = 0; i < 5; i++) {
				testNumPrint.print1();
			}
		},"打印1的线程1").start();
		
		// 打印1的线程2
		new Thread(()->{
			for (int i = 0; i < 5; i++) {
				testNumPrint.print1();
			}
		},"打印1的线程2").start();

	}

}
