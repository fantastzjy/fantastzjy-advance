package Java_原理相关.接口与抽象类;

interface AI {
}

class BI implements AI {
}

public class 测试instanceof {
    public static void main(String[] args) {
        AI a = new BI();
        BI b = new BI();
        System.out.println(a instanceof AI);
        System.out.println(b instanceof AI);
        System.out.println(a instanceof BI);
        System.out.println(b instanceof BI);
        //true //true //true //true  看右边 看他具体是哪个类
    }
}


