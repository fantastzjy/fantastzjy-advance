package java相关原理.juc.thread;

public class MyTicket {

    public static int num = 10;


    public synchronized void sale() {
        int a = 0;
        num--;
        System.out.println(Thread.currentThread().getName() + "买了一张票，剩余票数" + num);
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        MyTicket.num = num;
    }


    public static void main(String[] args) {

        System.out.println("主线程开始");

        MyTicket t02_myTicket = new MyTicket();

        for (int i = 0; i < 10
                ; i++) {
            new Thread(() -> {
                t02_myTicket.sale();
            }, "线程" + i).start();
        }

        System.out.println("主线程结束");

    }
}
