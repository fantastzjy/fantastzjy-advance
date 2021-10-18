package java相关原理.static关键字;

/*
静态变量和静态代码块会有cinit   静态方法没有cinit  ！！！！！
只是静态方法 里面没有this引用  而普通方法中第一个变量是this引用  所以静态方法不能引用非静态成员变量与费静态成员方法
 */

public class s {

    private String ds = "";
    private static String sta = "";

    //static {
    //    String st = "d";
    //}
    //
    //public static void staticmethod() {
    //}

    public void method() {
        this.ds = "";
    }
}
