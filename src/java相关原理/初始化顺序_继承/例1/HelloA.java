package java相关原理.初始化顺序_继承.例1;

public class HelloA {
    public HelloA() {//构造函数
        System.out.println("A的构造函数");
    }

    {//构造代码块
        System.out.println("A的构造代码块");
    }

    static {//静态代码块
        System.out.println("A的静态代码块");
    }
}

class HelloB extends HelloA {
    public HelloB() {//构造函数
        System.out.println("B的构造函数");
    }

    {//构造代码块
        System.out.println("B的构造代码块");
    }

    static {//静态代码块
        System.out.println("B的静态代码块");
    }

    public static void main(String[] args) {
        HelloB b = new HelloB();
    }
}
//运行结果：
//        A的静态代码块
//        B的静态代码块
//        A的构造代码块
//        A的构造函数
//        B的构造代码块
//        B的构造函数

//简单理解
// 其中静态代码块是编译时确定 字节码层面 执行cinit之前要先执行父类的cinit
// 代码块和构造器  都是实例化对象时使用  也是先父类构造器再子类构造器  而代码块在构造器之前执行  所以顺序就出来了