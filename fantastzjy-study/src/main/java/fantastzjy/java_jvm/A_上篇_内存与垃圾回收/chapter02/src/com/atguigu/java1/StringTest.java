package fantastzjy.java_jvm.A_上篇_内存与垃圾回收.chapter02.src.com.atguigu.java1;

/**
 * @author shkstart
 * @create 2020 上午 11:39
 */
public class StringTest {

    public static void main(String[] args) {
        String str = new String();
        System.out.println("hello,atguigu.com");

        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());
    }
}
