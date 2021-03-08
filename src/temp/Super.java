package temp;

public class Super {
    protected int number;

    protected void showNumber() {
        System.out.println("number = " + number);
    }
}

class Sub extends Super {
    public Sub(int i){
        super.number = 10;
        super.showNumber();
    }
    void bar() {
        int i = 0;
        super.number = 20;
        super.showNumber();
    }

    public static void main(String[] args) {
        new Sub(1).bar();
    }
}