package 面试;

public class StringPool58Demo {
    public static void main(String[] args) {
        //new String("58tongcheng");   //方式会创建两个三个对象  分别在堆和stringtable中

        //String s1 = new StringBuilder("58").append("tongcheng").toString();
        String s1 = new String("58tongcheng");
        //"58tongcheng".intern();
        System.out.println(s1.intern());  //返回的是字符串 不是地址
        System.out.println(s1 == s1.intern());

        String s2 = new StringBuilder("ja").append("va").toString();
        s2.intern();
        System.out.println(s2 == s2.intern());

        System.out.println();


        String str1 = new String("aaabbba");
        //System.out.println(System.identityHashCode(str1)); //打印出832279283，即字符串对象在堆中的地址
        //System.out.println(System.identityHashCode(str1.intern())); //打印出265119009，即返回的是字符串在字符串常量池中的地址
        str1.intern();
        String str2 = "aaabbba";
        //System.out.println(System.identityHashCode(str2)); //打印出265119009，和前面一样，因为aaa在字符串常量池中是唯一的，aaa之前被intern了

        System.out.println(str1 == str2); //打印出false，比较的是地址值
    }

}
