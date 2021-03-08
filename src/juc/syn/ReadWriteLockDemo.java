package juc.syn;

/**
 * `
 *
 * @author xialei
 * @Description: 一个线程写入, 100个线程读取
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue();

        // 以为老师调用写操作，修改屏幕信息
        new Thread(() -> {
            myQueue.writeObj("下课啦");
        }, "徐老师").start();
        //

        new Thread(() -> {
            myQueue.writeObj("没下课啦，继续上课");
        }, "李老师").start();

        // 100同学调用读操作，读取屏幕信息
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                myQueue.readObj();
            }, "同学小" + i).start();
        }

    }
}
