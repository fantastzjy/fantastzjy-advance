package fantastzjy.java_jvm.B_中篇_字节码与类的加载.chapter02_字节码指令集与解析举例.java;

/**
 * @author shkstart
 * @create 2020-09-10 17:26
 * 补充：方法调用指令的补充说明
 */
public class InterfaceMethodTest {
    public static void main(String[] args) {
        AA aa = new BB();

        aa.method2();

        AA.method1();
    }
}


interface AA {
    public static void method1() {

    }

    public default void method2() {

    }
}

class BB implements AA {

}
