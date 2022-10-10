package fantastzjy.java_jvm.B_中篇_字节码与类的加载.chapter02_字节码指令集与解析举例.java1;

/**
 * @author shkstart
 * @create 2020-09-08 13:54
 * <p>
 * 指令9：同步控制指令
 */
public class SynchronizedTest {

    private int i = 0;

    public void add() {
        i++;
    }


    private Object obj = new Object();

    public void subtract() {

        synchronized (obj) {
            i--;
        }
    }
}