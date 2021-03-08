package dataConstruct.other;

public class b {
    public static void main(String[] args) {
        String s1 = "我";
        String s2 = "们";
        String s3 = "我们";
        String s4 = new String("我们");
        String s5 = "我" + "们";
        String s6 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
    }
}