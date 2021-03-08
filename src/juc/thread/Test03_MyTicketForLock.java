package juc.thread;

public class Test03_MyTicketForLock {

    public static void main(String[] args) {

        MyTicketForLock myTicket = new MyTicketForLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                myTicket.sale();
            }, "消费者lock锁测试线程" + i).start();// 执行卖票任务
        }

    }

}
