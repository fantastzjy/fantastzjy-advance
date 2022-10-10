package fantastzjy.java_jvm.B_中篇_字节码与类的加载.chapter02_字节码指令集与解析举例.java;

/**
 * @author shkstart
 * @create 2020-09-08 10:13
 * <p>
 * 指令6：操作数栈管理指令
 */
public class StackOperateTest {

    public void print() {
        Object obj = new Object();
//        String info = obj.toString();
        obj.toString();
    }

    //类似的
    public void foo() {
        bar();
    }

    public long bar() {
        return 0;
    }

    public long nextIndex() {
        return index++;
    }

    private long index = 0;
}
