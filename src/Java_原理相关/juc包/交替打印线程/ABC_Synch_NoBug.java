package Java_原理相关.juc包.交替打印线程;

/**
 * 为了解决ABC_Synch_HaveBug的问题，最直接的思路就是在最后一次打印操作时在不休眠线程的情况下释放对象锁，这可以通过notifyAll操作实现。
 * 下面代码可以自动结束线程了。从这里，我们也可以得出wait和notify操作的异同：
 * wait() 与 notify/notifyAll() 是Object类的方法，在执行两个方法时，要先获得锁。
 * 当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。
 * 当执行notify/notifyAll方法时，会唤醒一个处于等待该 对象锁 的线程，然后继续往下执行，直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁。
 * 从这里可以看出，notify/notifyAll()执行后，并不立即释放锁，而是要等到执行完临界区中代码后，再释放。
 * 所以在实际编程中，我们应该尽量在线程调用notify/notifyAll()后，立即退出临界区。即不要在notify/notifyAll()后面再写一些耗时的代码。
 */

public class ABC_Synch_NoBug {
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
            int count = 10;//控制while循环10次
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);// 打印
                        count--;
                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。 synchronized (self){} 执行完才释放
                    }
                    // 此时执行完self的同步块，这时self锁才释放。
                    try {
                        if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            prev.notifyAll();
                        } else {
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
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
        //确保是同一个对象  非静态 synchronized锁的是同一个对象
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        Thread.sleep(100);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
