package java_principle.juc包.thread;

import java.util.concurrent.FutureTask;

public class 测试callable创建线程方式 {

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        }).start();

        //new Thread(new Callable()) {		}// 无法将callable当多线程参数

        new Thread(new FutureTask(null)).start();// 要加一个方法包装一下才能实现
        //Runnable是lang包下的   callable是juc包下的

    }

}
