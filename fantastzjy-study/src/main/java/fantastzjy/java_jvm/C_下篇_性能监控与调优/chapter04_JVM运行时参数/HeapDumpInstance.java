package fantastzjy.java_jvm.C_下篇_性能监控与调优.chapter04_JVM运行时参数;

import java.util.ArrayList;

/**
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+HeapDumpBeforeFullGC
 * -XX:HeapDumpPath=d:\heapdumpinstance.hprof
 *
 * @author shkstart
 * @create 10:16
 */
public class HeapDumpInstance {
    private static int _1MB = 1024 * 1024;
    byte[] buffer = new byte[10 * _1MB];

    public static void main(String[] args) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<HeapDumpInstance> list = new ArrayList<HeapDumpInstance>();
        for (int i = 0; i < 500; i++) {
            list.add(new HeapDumpInstance());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序执行结束");
    }
}
