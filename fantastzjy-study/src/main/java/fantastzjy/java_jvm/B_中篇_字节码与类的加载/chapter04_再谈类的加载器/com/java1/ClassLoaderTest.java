package fantastzjy.java_jvm.B_中篇_字节码与类的加载.chapter04_再谈类的加载器.com.java1;

/**
 * @author shkstart
 * @create 9:37
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        Object object = new Object();//Object类的加载只能使用引导类加载器进行！
    }
}
