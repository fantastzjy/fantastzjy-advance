package juc.thread;

public class Test08_Cooking {

	public static void main(String[] args) {

		System.out.println("餐馆开张了");

		Cooking cooking = new Cooking();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				cooking.cut();
			}
		}, "张小切师傅").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				cooking.cook();
			}
		}, "李小炒师傅").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				cooking.giving();
				System.out.println("第" + (i + 1) + "道菜完成。。。");
			}
		}, "王小端师傅").start();

	}

}
