package java相关原理;

public class string测试 {
    public static void main(String[] args) {
        //true true
        //String s1 = new String("hello");
        //String s2 = s1 + "world";
        //System.out.println(s2.intern() == "helloworld");
        //System.out.println(s2 == "helloworld");

        //下面两个一组比较
        //false  加上final变化是啥
        //final String s1 = "hello";
        //final String s2 = new String(s1 + "world");
        //String s3 = s2.intern();
        //System.out.println(s3 == s2);

        //true
        //final String s1 = new String("hello");
        //final String s2 = new String(s1 + "world");
        //String s3 = s2.intern();
        //System.out.println(s3 == s2);


        //false
        //true
        //Float a= 127F, b = Float.valueOf("127");
        //Long c = -127L, d = Long.valueOf("-127");
        //System.out.println(a == b);
        //System.out.println(c == d);

        //Random random = new Random();
        //for (int i = 0; i <1000 ; i++) {
        //    System.out.println(random.nextInt(10));   输出范围0-9
        //    System.out.println(random.nextInt(100)+" ");   //输出范围0-99
        //}
        //HashMap<Object, Object> hashMap = new HashMap<>();
        //Object[] values = hashMap.values().toArray();
        //String randomValue = (String) values[random.nextInt(values.length)];
    }


}
