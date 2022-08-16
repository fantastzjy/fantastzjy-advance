package Java_JVM.B_中篇_字节码与类的加载.chapter03_类的加载过程详解.java_p71_p79;

import org.junit.Test;

import java.util.Random;

/**
 * @author shkstart
 * @create 2020-09-14 16:49
 *
 * 3. 当使用类、接口的静态字段时(final修饰特殊考虑)，比如，使用getstatic或者putstatic指令。（对应访问变量、赋值变量操作）
 *
 */
public class ActiveUse2 {
    @Test
    public void test1(){
//        System.out.println(User.num);
//        System.out.println(User.num1);//获取的是常量的值，未涉及到clinit方法的执行       <注意，此时加载还是加载了，只是没有进行初始化>
        System.out.println(User.num2);//new Random() 要调用该方法，该方法在clinit方法中，所以一定需要执行clinit，就进行了初始化
    }

    @Test
    public void test2(){
//        System.out.println(CompareA.NUM1);
        System.out.println(CompareA.NUM2);
    }
}

class User{
    static{
        System.out.println("User类的初始化过程");
    }

    public static int num = 1;
    public static final int num1 = 1;
    public static final int num2 = new Random().nextInt(10);

}

interface CompareA {

    //匿名内部类，作用：如果执行clinit时输出，监测是否执行初始化过程，<在初始化时执行clinit方法>
    public static final Thread t = new Thread() {
        {
            System.out.println("CompareA的初始化");
        }
    };

    public static final int NUM1 = 1;
    public static final int NUM2 = new Random().nextInt(10);

}