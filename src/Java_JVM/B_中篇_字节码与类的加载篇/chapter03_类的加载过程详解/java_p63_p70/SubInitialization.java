package Java_JVM.B_中篇_字节码与类的加载篇.chapter03_类的加载过程详解.java_p63_p70;

/**
 * @author shkstart
 * @create 2020-09-13 11:59
 */
public class SubInitialization extends InitializationTest {
    static{
        number = 4;//number属性必须提前已经加载：一定会先加载父类。
        System.out.println("son static{}");
    }

    public static void main(String[] args) {
        System.out.println(number);
    }
}
