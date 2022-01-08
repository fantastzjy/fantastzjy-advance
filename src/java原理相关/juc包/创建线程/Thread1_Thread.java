package java原理相关.juc包.创建线程;

public class Thread1_Thread extends Thread {

    @Override
    public void run() {
        System.out.println("通过继承thread类");
    }

    public static void main(String[] args) {

        //法一 写函数式表达式
        Thread t1 = new Thread1_Thread();
        t1.start();

        //法二
        Thread t2 = new Thread(() -> {
            System.out.println("jxis");
        });

        t2.start();
    }

}
