package juc.thread;

/**
 * java8特点：
 * 非函数式接口能包含‘多个’未实现方法，函数式不可以
 * java8中可以写’多个‘未实现方法的实现，但是要写default关键字， java7 不可以
 * 接口中普通方法不能写实现，如果想要写实现必须加上static关键字
 */

//@FunctionalInterface  函数式接口注解
public interface Test09_Interface {

    public void a();

    public void b();

    default public void c() {

    }

    default public void d() {

    }


    public static void e() {

    }

    public static void f() {

    }


}
