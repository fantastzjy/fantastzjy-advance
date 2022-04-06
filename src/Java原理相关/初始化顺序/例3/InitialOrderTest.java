package Java原理相关.初始化顺序.例3;

public class InitialOrderTest {
    /* 静态变量 */
    public static String staticField = "静态变量";
    /* 变量 */
    public String field = "变量";

    /* 静态初始化块 */
    static {
        //staticField = "ccccc";// 若是将staticField的定义放到后面这里可以赋值 但是不会调用  且这里赋值会是无用功
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    /* 初始化块 */ {
        System.out.println(field);  //要是将变量放到后面会报错
        System.out.println("初始化块");
    }

    /* 构造器 */
    public InitialOrderTest() {
        System.out.println("构造器");
    }


    public static void main(String[] args) {
        new InitialOrderTest();
    }
}

//静态变量
//静态初始化块
//变量             变量与初始化快的关系相当于 静态变量与 静态初始化块 的关系
//初始化块
//构造器            最后才是构造器

//对象属性赋值的顺序--》
//1、属性的默认值初始化    ---初始化分配到的内存空间时  设置属性的默认值  保证对象的实例字段不赋值时可以直接使用
//2、显示初始化/代码块初始化
//3、构造器初始化