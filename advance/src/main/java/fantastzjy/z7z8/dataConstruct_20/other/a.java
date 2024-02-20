package fantastzjy.z7z8.dataConstruct_20.other;


class A {
    double m(double x, double y) {
        return x * y;
    }
}

class B extends A {
    double m(double x, double y) {
        return x + y;
    }

    double m(float x, float y) {
        return x - y;
    }

}


public class a {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.m(2.0, 3.0));
        System.out.println(b.m(4.0f, 3.0f));
        A a = b;
        System.out.println(a.m(2.0, 3.0));
    }


}