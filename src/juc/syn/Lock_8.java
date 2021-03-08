package juc.syn;

class Phone {

	public  static synchronized void sendSMS() throws Exception {

		Thread.sleep(3000);

		System.out.println("------sendSMS");
	}

	public  synchronized void sendEmail() throws Exception {
		System.out.println("------sendEmail");
	}

	public void getHello() {
		System.out.println("------getHello");
	}

}

/**
 * 
 * @Description: 8锁
 * @author xialei
 * 
 *         1 标准访问，先打印短信还是邮件 2 停4秒在短信方法内，先打印短信还是邮件 3 新增普通的hello方法，是先打短信还是hello 4
 *         现在有两部手机，先打印短信还是邮件 5 两个静态同步方法，1部手机，先打印短信还是邮件 6 两个静态同步方法，2部手机，先打印短信还是邮件
 *         7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件 8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件
 *         ---------------------------------
 * 
 */
public class Lock_8 {
	public static void main(String[] args) throws Exception {

		Phone phone = new Phone();
		//Phone phone1 = new Phone();

		new Thread(() -> {
			try {
				phone.sendSMS();// 发短信
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "张三").start();

		Thread.sleep(1000);

		new Thread(() -> {
			try {
				phone.sendEmail();// 发邮件
				//phone1.sendEmail();// 发邮件
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "李四").start();
	}
}