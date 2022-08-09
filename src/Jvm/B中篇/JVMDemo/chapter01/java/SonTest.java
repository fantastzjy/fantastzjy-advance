package Jvm.B中篇.JVMDemo.chapter01.java;
/*
成员变量（非静态的）的赋值过程： ① 默认初始化 - ② 显式初始化 /代码块中初始化 - ③ 构造器中初始化 - ④ 有了对象之后，可以“对象.属性”或"对象.方法"
 的方式对成员变量进行赋值。
 */
class Father {
    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }
    public void print() {
        System.out.println("Father.x = " + x);
    }
}

class Son extends Father {
    int x = 30;
//    float x = 30.1F;
    public Son() {
        this.print();
        x = 40;
    }
    public void print() {
        System.out.println("Son.x = " + x);
    }
}

public class SonTest {
    public static void main(String[] args) {

        Father f0 = new Father();
        System.out.println(f0.x);
        //结果
        //Father.x = 10
        //20

        //是否进行过初始化过，不影响下面结果，即类是否记载过不影响实例化实例化

        Father f = new Son();
        System.out.println(f.x);
        //结果
        //Son.x = 0       //父类构造器初始化，调用的子类的print，此时子类的x只有默认0值，在输出前还未进行变量初始化
        //Son.x = 30      //子类构造器初始化，子类覆盖了父类的print，使用了子类的刚赋过值的x
        //20              //输出，变量不具有多态性，使用的仍然是父类的x

    }
}
