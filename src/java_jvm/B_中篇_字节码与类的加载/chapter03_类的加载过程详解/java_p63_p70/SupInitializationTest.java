package java_jvm.B_中篇_字节码与类的加载.chapter03_类的加载过程详解.java_p63_p70;

/**
 * @author shkstart
 * @create 2020-09-13 11:55
 * <p>
 * 过程三：初始化阶段
 */
public class SupInitializationTest {
    public static int id = 1;
    public static int number;

    static {
        number = 2;
        System.out.println("father static{}");
    }
}
