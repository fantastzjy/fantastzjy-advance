package Java_JVM.C_下篇_性能监控与调优.chapter03.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟内存泄漏
 *
 * @author shkstart
 * @create 21:20
 */
public class MemoryLeak {
    static List list = new ArrayList();

    public void oomTests() {
        Object obj = new Object();
        list.add(obj);
    }

}