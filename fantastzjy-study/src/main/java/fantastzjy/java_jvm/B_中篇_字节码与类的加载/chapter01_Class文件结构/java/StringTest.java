package fantastzjy.java_jvm.B_中篇_字节码与类的加载.chapter01_Class文件结构.java;

/**
 * @author shkstart
 * @create 2020-09-01 21:32
 */
public class StringTest {
    public static void main(String[] args) {
        String str = new String("hello") + new String("world");
        String str1 = "helloworld";
        System.out.println(str == str1);
        String str2 = new String("helloworld");
        System.out.println(str == str2);
    }

    public void method1() {

    }

    public void method1(int num) {

    }

//    public int method1(int num){
//        return 1;
//    }
}
