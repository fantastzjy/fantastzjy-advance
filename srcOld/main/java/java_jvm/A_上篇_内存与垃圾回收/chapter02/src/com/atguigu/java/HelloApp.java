package java_jvm.A_上篇_内存与垃圾回收.chapter02.src.com.atguigu.java;

/**
 * @author shkstart
 * @create 2020 上午 11:43
 */
public class HelloApp {
    private static int a = 1;//prepare：a = 0 ---> initial : a = 1


    public static void main(String[] args) {
        System.out.println(a);
    }
}
