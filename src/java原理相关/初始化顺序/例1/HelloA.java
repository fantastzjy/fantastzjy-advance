package java原理相关.初始化顺序.例1;

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
    }
}

//运行结果 ：A的静态代码块

//说明 静态代码块是类初始化时初始化
//构造器和构造代码块是实例化对象时使用的   构造代码块--所有对象   构造器--满足该构造器重载类型的