package java原理相关.juc包.交替打印线程;


/**
 * 需要state状态量 来控制 while循环是否结束
 * 在while循环中 获取两把锁  获取到了就打印并 state ++ 先释放self  在释放 prev
 * 释放第二把锁时 看是否是最后一次打印  如果是就 notifyall 会释放掉锁  如果是wait 只是睡眠 线程不会结束
 */

public class SynchronizedTest extends Thread {
    private Object prev;
    private Object self;
    private String name;


    public SynchronizedTest(String name, Object prev, Object self) {
        this.prev = prev;
        this.self = self;
        this.name = name;
    }

    @Override
    public void run() {
        int state = 0;
        //要将两个synchronized也放进来！！！！！！！！！  不然只会输出打印一次  而且线程不会挺 因为最后至西宁的是wate（）
        while (state < 10) {

            synchronized (prev) {
                synchronized (self) {
                    System.out.println("打印 " + name);
                    state++;
                    self.notifyAll();
                }

                try {
                    if (state == 10) {
                        prev.notifyAll();
                    } else {
                        prev.wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        SynchronizedTest A = new SynchronizedTest("A", c, a);
        A.start();
        SynchronizedTest B = new SynchronizedTest("B", a, b);
        B.start();
        SynchronizedTest C = new SynchronizedTest("C", b, c);
        C.start();

    }

}
