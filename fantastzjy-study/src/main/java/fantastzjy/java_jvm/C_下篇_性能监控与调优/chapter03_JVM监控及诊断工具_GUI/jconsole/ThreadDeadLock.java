package fantastzjy.java_jvm.C_下篇_性能监控与调优.chapter03_JVM监控及诊断工具_GUI.jconsole;

/**
 * 演示线程的死锁问题
 *
 * @author shkstart
 * @create 下午 3:20
 */
public class ThreadDeadLock {

    public static void main(String[] args) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread() {
            @Override
            public void run() {

                synchronized (s1) {

                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }

            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {

                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

    }
}
