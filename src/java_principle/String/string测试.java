package java_principle.String;

import org.junit.Test;

public class string测试 {

    @Test
    public void test1() {
        final String sl = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = sl + s2;
        System.out.println(s3 == s4); //true

//        反编译后为
//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "ab";
//        String s4 = "ab";
//        System.out.println(s3 == s4);

    }

    public static void main(String[] args) {
        /*
        总结：
        如果是字面量创建
            直接在字符串常量池中创建并返回池中地址  不会在堆里面 new对象
        如果是new创建 字符串常量池和堆中都会创建
            调用intern 如果是拼接创建的new String("a")+new String("b") 常量池中不含有 ab
                            1.7  会将堆中的地址引用赋值给常量池
                            1.6  在常量池中创建一个新的ab
                      如果是直接创建 new String("ab")  堆中和常量池(假如没有)都各自创建一个  ab   调用intern会返回常量池中的地址！！
           如果定义为 final String s2 = “ab” 表示s2 （注意没有new） 是一个常量 在进行拼接操作时当做常量处理   其他的只要包含变量就会创建新的
           如果定义为 final String s2 = new String("hello");   s2不是一个常量 只是一个不可变量
         */
        //一组
        {
            //String s1 = new String("hello");
            //String s2 = s1 + "world";
            //System.out.println(s2.intern() == "helloworld");//比较的是地址  常量池中没有 引用放进去
            //System.out.println(s2 == "helloworld");         //会去常量池中查找然后返回地址和s2比较
            //true true

            //上例的改编
            //String s1 = new String("hello");
            //String s2 = s1 + "world";
            //System.out.println(s2 == "helloworld");         //因为还没有调用intern 所以会在池中创建
            //System.out.println(s2.intern() == "helloworld");//s2.intern()返回的是上一步池中创建的地址 所以为true
            //System.out.println(s2 == "helloworld");         //地址不相同
            //false        //true        //false
        }


        //下面两个一组比较
        {
            //加上final后

            //final String s1 = "hello";                   //s1变成常量   对s1 赋值的是s1在池中的地址
            //final String s2 = new String(s1 + "world");  //常量-编译期优化   池中和堆中各自创建一个 helloword
            //String s3 = s2.intern();                     //返回的是池中自己创建的   s3值 是池中自己创建的地址
            //System.out.println(s3 == s2);                //s2是堆中的地址 s3 池中   false


            //final String s1 = new String("hello");        //上一例的区别处   s1不是常量了
            //final String s2 = new String(s1 + "world");   //s1 不是常量了
            //String s3 = s2.intern();                       //由于池中没有 所以返回的是s2在池中的引用
            //System.out.println(s3 == s2);                  //true

        }
        //false
        //true
        //Float a= 127F, b = Float.valueOf("127");
        //Long c = -127L, d = Long.valueOf("-127");
        //System.out.println(a == b);
        //System.out.println(c == d);

        //随机输出hashmap中的值   思路：将value输出为一个数组
        //Random random = new Random();
        //HashMap<Object, Object> hashMap = new HashMap<>();
        //Object[] values = hashMap.values().toArray();
        //String randomValue = (String) values[random.nextInt(values.length)];


        // for (int i = 0; i <1000 ; i++) {  //测试输出范围
        //        //    System.out.println(random.nextInt(10));   输出范围0-9
        //        //    System.out.println(random.nextInt(100)+" ");   //输出范围0-99
        //        //}

    }


}
