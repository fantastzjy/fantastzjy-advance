package fantastzjy.java_jvm.A_上篇_内存与垃圾回收.chapter17.src.com.atguigu.java;

import java.util.ArrayList;

/**
 * -XX:+PrintCommandLineFlags
 * <p>
 * -XX:+UseSerialGC:表明新生代使用Serial GC ，同时老年代使用Serial Old GC
 * <p>
 * -XX:+UseParNewGC：标明新生代使用ParNew GC
 * <p>
 * -XX:+UseParallelGC:表明新生代使用Parallel GC
 * -XX:+UseParallelOldGC : 表明老年代使用 Parallel Old GC
 * 说明：二者可以相互激活
 * <p>
 * -XX:+UseConcMarkSweepGC：表明老年代使用CMS GC。同时，年轻代会触发对ParNew 的使用
 *
 * @author shkstart  shkstart@126.com
 * @create 2020  0:10
 */
public class GCUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        while (true) {
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
