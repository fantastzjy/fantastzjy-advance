package juc.thread;

public class Test02_MyTicket {

    public static void main(String[] args) {

        System.out.println("主线程开始");

        MyTicket t02_myTicket = new MyTicket();

        for (int i = 0; i < 10
                ; i++) {
            new Thread(() -> {
                t02_myTicket.sale();
            },"线程"+i).start();
        }

        System.out.println("主线程结束");

    }

}
