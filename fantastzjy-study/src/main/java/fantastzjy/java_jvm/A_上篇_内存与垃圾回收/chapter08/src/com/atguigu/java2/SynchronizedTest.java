package fantastzjy.java_jvm.A_上篇_内存与垃圾回收.chapter08.src.com.atguigu.java2;

/**
 * 同步省略说明
 *
 * @author shkstart  shkstart@126.com
 * @create 2020  11:07
 */
public class SynchronizedTest {
    public void f() {
        Object hollis = new Object();
        synchronized (hollis) {
            System.out.println(hollis);
        }
    }
}
