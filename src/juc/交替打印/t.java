package juc.交替打印;

public class t {

    public static void main(String[] args) {
        int state = 1;
        while (state % 3 == 0) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
            System.out.print("A");
            state++;

        }
    }

}
