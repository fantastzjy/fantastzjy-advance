package Jvm.B_中篇_字节码与类的加载篇.chapter04.com.java;

/**
 * @author shkstart
 * @create 10:36
 */
public class UserTest {
    public static void main(String[] args) {
        User user = new User(); //隐式加载

        try {
            Class clazz = Class.forName("com.atguigu.java.User"); //显式加载
            ClassLoader.getSystemClassLoader().loadClass("com.atguigu.java.User");//显式加载
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
