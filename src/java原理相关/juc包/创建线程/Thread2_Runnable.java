package java原理相关.juc包.创建线程;

public class Thread2_Runnable implements Runnable {

    @Override
    public void run() {
        System.out.println("通过实现runnable接口");
    }


    public static void main(String[] args) {

        //法一 写函数式表达式
        Thread t1 = new Thread(new Thread2_Runnable());
        t1.start();

    }

}
