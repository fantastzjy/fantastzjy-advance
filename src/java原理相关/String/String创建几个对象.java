package java原理相关.String;

import org.junit.Test;

public class String创建几个对象 {

    @Test
    public void test() {
        //打印地址输出的直接就是字符串值  因为string类型实现了tostring，，，，看源码直接输出了this对象！！！！
        //public String toString() {
        //    return this;
        //}

        System.out.println(new String("aaaaaaaaaaaaaaaaaaaaa").intern());
        System.out.println("aaaaaaaaaaaaaaaaaaaaa".intern());
        System.out.println("oppppp");
        String s1 = new String("ab");
        //创建两个 堆中 池中

        String s2 = "cd";
        //创建一个  池中

        String s3 = new String("e") + new String("f");
        //六个
        //对象1: new StringBuilder()
        //对象2: new string("a")
        //对象3: 常量池中的 "a"
        //对排4: new String("b")
        //对象5∶ 常量池中的 "b"

        //深入部折:stringBuilder的toString( ):
        //对象6: new String( "ab" )

        //原理
        //StringBuilder对象 对2和3拼接后调用 tostring生成new String( "ab" )
        //强调一下，toString ( )的调用，在字符串常量池中，没有生成 "ab"！！！！！！
        //因为 tostrign方法的实现是
        //       new String(value, 0, CountSort);   !!!!   value为char[]  数组

        String sb = new StringBuilder("sb").toString();
        //池中没有sb
        String sb2 = new StringBuilder("sb").toString().intern();
        //1.6 在池中创建一个新的sb返回   1.7将堆中sb的引用赋值给池中，又返回池中的引用--最终还是堆中的sb

        //执行完下—行代码以后，字符串常量池中，是否存在"1l"呢?答案:不存在!!
        String s4 = new String("1") + new String("1"); //new String("1l")


    }


}
