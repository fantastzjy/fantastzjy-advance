package java相关原理.初始化顺序.例2;

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

    public static void main(String[] args) {
        HelloA a = new HelloA();
    }
}

//运行结果：
//        A的静态代码块
//        A的构造代码块
//        A的构造函数