package fantastzjy.java_jvm.C_下篇_性能监控与调优.chapter02_JVM监控及诊断工具_命令行.jstack;

/**
 * 演示线程：TIMED_WAITING
 *
 * @author shkstart
 * @create 15:28
 */
public class TreadSleepTest {
    public static void main(String[] args) {
        System.out.println("hello - 1");
        try {
            Thread.sleep(1000 * 60 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello - 2");
    }
}
