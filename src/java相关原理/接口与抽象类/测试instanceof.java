package java相关原理.接口与抽象类;

interface AI {
}

class B implements AI {
}

public class 测试instanceof {
    public static void main(String[] args) {
        AI a = new B();
        B b = new B();
        System.out.println(a instanceof AI);
        System.out.println(b instanceof AI);
        System.out.println(a instanceof B);
        System.out.println(b instanceof B);
    }
}


