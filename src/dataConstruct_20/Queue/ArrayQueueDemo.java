package dataConstruct_20.Queue;

import java.util.Scanner;

/**
 * @create 2020-05-21-11:00
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        boolean loop = true;
        Scanner in = new Scanner(System.in);
        while (loop) {
            System.out.println("s 显示队列");
            System.out.println("a 添加数据");
            System.out.println("g 取出数据");
            System.out.println("h 查看队列头数据");
            System.out.println("e 退出程序");
            key = in.next().charAt(0); //取字符的第一个字符
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = in.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://取出数据  都要加一个try捕获异常 判断
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        //如果没有取出数据  在getQueue()中就会抛出异常
                        //异常的信息就是throw new RuntimeException("队列为空，不能取出数据");抛出异常时里面写的话
                        System.out.println(e.getMessage());//直接将异常信息打印
                    }
                    break;//break一直在最后
                case 'h'://显示队列头数据也会有异常
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    in.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，front指向队列头前一个位置
        rear = -1;//指向队列尾 ，队列最后一个数据的位置
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满,不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据");
            //return;   这里不用写return 上一句的抛异常就已经包含终止了 任何代码都不能执行了
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据可以显示数据");
        }
        for (int i = front+1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空 没有数据");
        }
        return arr[front + 1];  //注意这里不能是数组第一个  front+1不一定是在数组0坐标处
    }
}