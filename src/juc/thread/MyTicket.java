package juc.thread;

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


}
