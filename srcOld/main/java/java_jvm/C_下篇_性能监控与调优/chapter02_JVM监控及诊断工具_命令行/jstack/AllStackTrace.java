package java_jvm.C_下篇_性能监控与调优.chapter02_JVM监控及诊断工具_命令行.jstack;

import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 15:51
 */
public class AllStackTrace {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = all.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> en : entries) {
            Thread t = en.getKey();
            StackTraceElement[] v = en.getValue();
            System.out.println("【Thread name is :" + t.getName() + "】");
            for (StackTraceElement s : v) {
                System.out.println("\t" + s.toString());
            }
        }
    }
}
