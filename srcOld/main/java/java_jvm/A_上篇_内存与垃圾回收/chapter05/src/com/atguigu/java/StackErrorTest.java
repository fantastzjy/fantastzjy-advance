package java_jvm.A_上篇_内存与垃圾回收.chapter05.src.com.atguigu.java;

/**
 * 演示栈中的异常:StackOverflowError
 * @author shkstart
 * @create 2020 下午 9:08
 *
 *  默认情况下：count : 11420
 *  设置栈的大小： -Xss256k : count : 2465
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }

}
