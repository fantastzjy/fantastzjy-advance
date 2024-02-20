package fantastzjy.z7z8.dataConstruct.Queue;

import java.util.Scanner;

/**
 * @create 2020-05-21-15:00
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);//说明设置4，其队列的有效数据最大是3
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
                    } catch (Exception e) {
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

class CircleArray {
    private int maxSize;
    //front变量的含义做- -个调整: front 就指向队列的第-个元素，也就是说arr[front]
    //front的初始值= 0
    private int front;
    //rear变量的含义做一个调整: rear指向队列的最后- -个元素的后- - 个位置。因为希望空出一个位置
    //rear的初始值= 0 .
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
//        front = 0;  不用再写了  本来就是默认为 0
//        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满 不能添加元素");
        }
        arr[rear] = n;
//        rear++;  不能直接将rear后移  会越界的
//        将rear后移 这里考虑取模
        rear = (rear + 1) / maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空 不能得到元素");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }


    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据可以显示数据");
        }
        //思路 从front开始遍历要遍历多少个元素
        //要明白取模的意义front + size() 表示要比那里多少次
        //i % maxSize求出是真正的而第几个 则arr[i % maxSize] 表示那个位置上真正的元素
        for (int i = front + 1; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空 不能得到元素");
        }
        return arr[front];
    }

    //球当前队列的有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
