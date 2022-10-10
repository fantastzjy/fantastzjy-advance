package fantastzjy.java_jvm.C_下篇_性能监控与调优.chapter03_JVM监控及诊断工具_GUI.jprofiler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * p48 演示内存泄漏   案例2
 * 每一轮循环，beanList被gc ，Bean内静态链表内对象一直不能gc
 */
public class MemoryLeak {

    public static void main(String[] args) {
        while (true) {
            ArrayList beanList = new ArrayList();
            for (int i = 0; i < 500; i++) {
                Bean data = new Bean();
                data.list.add(new byte[1024 * 10]);//10kb
                beanList.add(data);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Bean {
    int size = 10;
    String info = "hello,atguigu";
    ArrayList list = new ArrayList();
    //static ArrayList list = new ArrayList();
}
