package Leetcode.A公司;

public class A {
    public int id = 1;

    public int id() {
        return id;
    }

    static public int sid = 2;

    static public int sid() {
        return sid;
    }


}

class B extends A {

    public int id = 3;

    public int id() {
        return id;
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.id);
        System.out.println(a.id());
        System.out.println(a.sid);

        //byte a = -112;
        //byte b = 87;
        //System.out.println(a & b);
    }

}