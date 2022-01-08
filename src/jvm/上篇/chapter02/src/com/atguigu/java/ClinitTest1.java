package jvm.上篇.chapter02.src.com.atguigu.java;

/**
 * @author shkstart
 * @create 2020 下午 8:40
 */
public class ClinitTest1 {
    static class Father{
        public static int A = 1;
        static{
            A = 2;
        }

    }

    static class Son extends Father{
        public static int B = 3;
    }

    public static void main(String[] args) {
        //加载Father类，其次加载Son类。
        System.out.println(Son.B);//2
    }
}
