package fantastzjy.java_design_patterns.TemplateMethod;


public class TemplateMethod {
    public static void main(String[] args) {
        //F f = new S();
        //f.m();

        F f = new S();
        f.m();
    }
}

abstract class F {
    public void m() {
        op1();
        op2();
    }

    abstract void op1();

    abstract void op2();
}

class S extends F {
    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}

