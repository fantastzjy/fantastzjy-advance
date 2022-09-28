package java_jvm.C_下篇_性能监控与调优.chapter03_JVM监控及诊断工具_GUI.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟内存泄漏
 *
 */
public class MemoryLeak {
    static List list = new ArrayList();

    public void oomTests() {
        Object obj = new Object();
        list.add(obj);
    }

}