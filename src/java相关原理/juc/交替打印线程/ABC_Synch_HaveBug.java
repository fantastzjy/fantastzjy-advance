package java相关原理.juc.交替打印线程;

/**
 * Synchronized同步法
 * 1、基本思路
 * 使用同步块和wait、notify的方法控制三个线程的执行次序。具体方法如下：
 * 从大的方向上来讲，该问题为三线程间的同步唤醒操作，主要的目的就是ThreadA->ThreadB->ThreadC->ThreadA循环执行三个线程。
 * 为了控制线程执行的顺序，那么就必须要确定唤醒、等待的顺序，所以每一个线程必须同时持有两个对象锁，才能进行打印操作。
 * 一个对象锁是prev，就是前一个线程所对应的对象锁，其主要作用是保证当前线程一定是在前一个线程操作完成后（即前一个线程释放了其对应的对象锁）才开始执行。
 * 还有一个锁就是自身对象锁。主要的思想就是，为了控制执行的顺序，必须要先持有prev锁（也就前一个线程要释放其自身对象锁）
 * ，然后当前线程再申请自己对象锁，两者兼备时打印。
 * 之后首先调用self.notify()唤醒下一个等待线程（注意notify不会立即释放对象锁，只有等到同步块代码执行完毕后才会释放）
 * ，再调用prev.wait()立即释放prev对象锁，当前线程进入休眠，等待其他线程的notify操作再次唤醒。
 */

public class ABC_Synch_HaveBug {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);//打印
                        count--;

                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                    }
                    //此时执行完self的同步块，这时self锁才释放。
                    try {
                        prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        /**
                         * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                         */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);//保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
    /**
     * 可以看到程序一共定义了a,b,c三个对象锁，分别对应A、B、C三个线程。A线程最先运行，A线程按顺序申请c,a对象锁，打印操作后按顺序释放a,c对象锁，并且通过notify操作唤醒线程B。线程B首先等待获取A锁，再申请B锁，后打印B，再释放B，A锁，唤醒C。线程C等待B锁，再申请C锁，后打印C，再释放C,B锁，唤醒A。看起来似乎没什么问题，但如果你仔细想一下，就会发现有问题，就是初始条件，三个线程必须按照A,B,C的顺序来启动，但是这种假设依赖于JVM中线程调度、执行的顺序。
     *
     * 原实现存在的问题：
     * 如果把上述代码放到eclipse上运行，可以发现程序虽然完成了交替打印ABC十次的任务，但是打印完毕后无法自动结束线程。这是为什么呢？原因就在于下面这段代码：
     * try {
     * prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
     *
     * //JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
     } catch(InterruptedException e){
     * e.printStackTrace();
     * }
     *prev.wait();是释放prev锁并休眠线程，等待唤醒。在最后一次打印完毕后，因为count为0，无法进入while循环的同步代码块，自然就不会触发notifyAll操作。这样一来，执行完打印操作后，线程就一直处于休眠待唤醒状态，导致线程无法正常结束。
     *
     *作者：和帅_db6a
     *链接：https://www.jianshu.com/p/f79fa5aafb44
     *来源：简书
     *著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

}
