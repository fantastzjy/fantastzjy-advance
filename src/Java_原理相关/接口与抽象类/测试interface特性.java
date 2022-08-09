package Java_原理相关.接口与抽象类;

/**
 * java8特点：
 * 非函数式接口能包含‘多个’未实现方法，
 * 函数式（加了@FunctionalInterface）就只能写一个未实现方法
 * java8中可以写’多个‘方法的实现，但是要写default关键字， java7 不可以有方法的实现
 * 接口中普通方法要想写实现必须加上static关键字  可以是 static
 */

//@FunctionalInterface  //函数式接口注解
public interface 测试interface特性 {

    public void a();

    public void b();

    default void c() {
        int q = 0;
    }

    default void d() {

    }

    public static void e() {

    }

    public static void f() {

    }


}
