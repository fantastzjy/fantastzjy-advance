package juc.thread;

public class Test01_synchronized {

    public static void main(String[] args) {

        new Thread().start();

    }

    public synchronized void a() {

        int a = 0;

        a = 1;

        if (1 == 1) synchronized (this) {

        }
        else {

        }
    }

}
