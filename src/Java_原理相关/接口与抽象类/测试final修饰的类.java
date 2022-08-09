package Java_原理相关.接口与抽象类;
/*
final关键字
        final关键字，意思是最终的、不可修改的，最见不得变化，用来修饰类、方法和变量，具有以下特点:
        1. final修饰的类不能被继承，final类中的所有成员方法都会被隐式的指定为final方法;
        2. final修饰的方法不能被重写;但是可以被继承和重载
        3. final修饰的变量是常量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改;如果是引用类型的变量，则在对其初始化之后便不能让其指向另一个对象。

        说明:使用final方法的原因有两个。第一个原因是把方法锁定，以防任何继承类修改它的含义;
        第二个原因是效率。在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升(现在的Java版本已经不需要使用final方法进行这些优化了)。
                       类中所有的private方法都隐式地指定为final。
 */

class A {
    public String s = "  ko ";
}

public class 测试final修饰的类 {
    A a = new A();
    A b = a;
    public final A c = b;

    public static void main(String[] args) {
        测试final修饰的类 fin = new 测试final修饰的类();
        fin.a.s = "";
        fin.c.s = "";  //不报错 因为没有改变引用
        //fin.c = fin.a;//报错 改变了b的引用指向   即使是堆内中同一个对象也不可以

        //所以只要不该变引用就可以
    }
}