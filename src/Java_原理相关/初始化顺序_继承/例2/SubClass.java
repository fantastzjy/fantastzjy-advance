package Java_原理相关.初始化顺序_继承.例2;

class Parent {
    /* 静态变量 */
    public static String p_StaticField = "父类--静态变量";
    /* 变量 */
    public String p_Field = "父类--变量";
    protected int i = 9;
    protected int j = 0;

    /* 静态初始化块 */
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }

    /* 初始化块 */ {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }

    /* 构造器 */
    public Parent() {
        System.out.println("父类--构造器");
        System.out.println("i=" + i + ", j=" + j);
        j = 20;
    }
}

public class SubClass extends Parent {
    /* 静态变量 */
    public static String s_StaticField = "子类--静态变量";
    /* 变量 */
    public String s_Field = "子类--变量";

    /* 静态初始化块 */
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }

    /* 初始化块 */ {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    /* 构造器 */
    public SubClass() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }


    /* 程序入口 */
    public static void main(String[] args) {
        System.out.println("子类main方法");
        new SubClass();
    }
}

/*
            父类--静态变量
            父类--静态初始化块
            子类--静态变量
            子类--静态初始化块
            子类main方法   当所有必要的类都已经装载结束，开始执行main()方法体，并用new SubClass（）创建对象。
                            ---前面的是编译时静态绑定  下面的才是实例化时使用的
            父类--变量
            父类--初始化块
            父类--构造器
            i=9, j=0    ------在构造器中输出的 随后进行了赋值
            子类--变量
            子类--初始化块
            子类--构造器
            i=9,j=20
            ------继承了父类的变量 包括值 所以继承的意义
                   如果没有重写的话就是继承所有  父类初始化的结果子类可以继承（继续使用）

### 分析
我的总结：关于类的加载及实例化
类的加载只是将的二进制字节流信息所代表的静态存储结构转化为在方法区的运行时数据结构
并且在内存中生成一个代表该类的java.lang.class对象，作为这个类的各种数据的访问入口
但是此时还没有进行连接初始化 等一系列初始化的操作 不能通过对象访问

调用main方法 需要先加载承载类  如果加载成功在先进行链接初始化操作(装载) 在装载的过程中如果有基类会先进行基类的装载(链接初始化就是静态变量静态初始化块)
完成后在调用承载类中的main方法
因为main方法中有代码  new SubClass();  所以会执行实例化的操作 此时再进行普通变量、普通代码块、构造器的初始化（实例化）父类完了再子类
( 如果该类没有main方法是没有运行按钮 即没办法执行 承载类就不会进行加载 只是会编译一下 因为静态变量随着类的加载而加载所以不会有静态方法的初始化
  如                  果有main方法 但是没有new SubClass() 就不会进行实例化的操作
 )

 对该例子的大佬总结
    (1)访问SubClass.main(),(这是一个static方法)，于是装载器就会为你寻找已经编译的SubClass类的代码（也就是SubClass.class文件）。
    在装载的过程中，装载器注意到它有一个基类（也就是extends所要表示的意思），于是它再装载基类。不管你创不创建基类对象，这个过程总会发生。
    如果基类还有基类，那么第二个基类也会被装载，依此类推。
     第一点这点重要啊！！！！！！！
    (2)执行根基类的static初始化，然后是下一个派生类的static初始化，依此类推。
         这个顺序非常重要，因为派生类的“static初始化”有可能要依赖基类成员的正确初始化。

    (3)当所有必要的类都已经装载结束，开始执行main()方法体，并用new SubClass（）创建对象。

    (4)类SubClass存在父类，则调用父类的构造函数，你可以使用super来指定调用哪个构造函数。
         基类的构造过程以及构造顺序，同派生类的相同。首先基类中各个变量按照字面顺序进行初始化，然后执行基类的构造函数的其余部分。

    (5)对子类成员数据按照它们声明的顺序初始化，执行子类构造函数的其余部分。

 */


