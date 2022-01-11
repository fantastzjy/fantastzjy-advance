package z7z8.dataConstruct.shiyan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @create 2020-05-24-15:45
 */
public class P {
    public static Integer PART_MONEY_HOUR = 2;
    public static Integer PART_MAXSIZE = 2;
    public static Integer WAIT_MAXSIZE = 100;

    public static void main(String[] args) {
        //��ʼ��ͣ���� �Լ����
        ParkingLotStack parkingLotStack = new ParkingLotStack(PART_MAXSIZE);
        WaitQueue waitQueue = new WaitQueue(WAIT_MAXSIZE);
        WaitQueue tempLot = new WaitQueue(WAIT_MAXSIZE);

        Scanner in = new Scanner(System.in);
        Car car = new Car();
        while (true) {
            try {
                System.out.println("������������Ϣ:");
                String carInf = in.next();
                String state = "" + carInf.charAt(1);
                String num = carInf.substring(3, 6);

                car.setNum(num);

                if (state.equals("A")) {
                    if (parkingLotStack.isFull()) {
                        //ͣ��������
                        System.out.printf("ͣ�������������[ %d ]���ȴ���\n", waitQueue.getSize() + 1);
                        waitQueue.addQueue(new Car(num, null, null, 0));
                    } else {
                        //ͣ����δ��
                        parkingLotStack.push(new Car(num, new Date(), null, 0));
                        System.out.printf("��%S��ͣ��ͣ����[ %d ]����\n", carInf, parkingLotStack.getTop());
                    }
                } else if (state.equals("D")) {
                    //���ж���û�иó���
                    if (parkingLotStack.search(num) == -1) {
                        System.out.println("ͣ����û�иó�����");
                    } else {
                        //����и�����
                        int local = parkingLotStack.search(num);
                        int i = parkingLotStack.getTop() - local;
                        int j = i;  //���ǰ�װ���� ����ֱ�Ӹ�ֵ ���ǵ�ַ
                        while (i > 0) {
                            tempLot.addQueue(parkingLotStack.pop());
                            i--;
                        }
                        car = parkingLotStack.pop();
                        car.setDtime(new Date());
                        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                        String fromDate = simpleFormat.format(car.getAtime());
                        String toDate = simpleFormat.format(car.getDtime());
                        long from = simpleFormat.parse(fromDate).getTime();
                        long to = simpleFormat.parse(toDate).getTime();
                        int hours = (int) ((to - from) / (1000 * 60 * 60)) + 1;
                        car.setMoney(hours * 2);
                        System.out.println(car);

                        while (j > 0) {
                            parkingLotStack.push(tempLot.getQueue());
                            j--;
                        }
                        if (!waitQueue.isEmpty()) {
                            parkingLotStack.push(waitQueue.getQueue());
                        }
                    }
                } else {
                    System.out.println("����ȷ������Ϣ������");
                }

            } catch (Exception e) {
                System.out.println("����ȷ������Ϣ������");
            }
        }

    }
}


//����һ�� parkingLotStack ��ʾջ
class ParkingLotStack {
    private int maxSize; // ջ�Ĵ�С
    private Car[] stack; // ���飬����ģ��ջ�����ݾͷ��ڸ�����
    private int top = -1;// top��ʾջ������ʼ��Ϊ-1

    public int getTop() {
        return top;
    }

    //������
    public ParkingLotStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Car[this.maxSize];
    }

    public int search(String num) {
        if (isEmpty()) {
            return -1;
        } else {
            for (int i = top; i >= 0; i--) {
                if (stack[i].getNum().equals(num)) {
                    return i;
                }
            }

        }
        return -1;
    }

    //ջ��
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    //��ջ-push
    public void push(Car car) {
        //���ж�ջ�Ƿ���
        if (isFull()) {
            System.out.println("ջ��");
            return;
        }
        top++;
        stack[top] = car;
    }

    //��ջ-pop, ��ջ�������ݷ���
    public Car pop() {
        //���ж�ջ�Ƿ��
        if (isEmpty()) {
            //�׳��쳣
            throw new RuntimeException("ջ�գ�û������~");
        }
        Car car = stack[top];
        top--;
        return car;
    }

    //��ʾջ�����[����ջ]�� ����ʱ����Ҫ��ջ����ʼ��ʾ����
    public void list() {
        if (isEmpty()) {
            System.out.println("ջ�գ�û������~~");
            return;
        }
        //��Ҫ��ջ����ʼ��ʾ����
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}


class WaitQueue {
    private int maxSize;
    private int front;
    private int rear;
    private Car[] arr;

    public WaitQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new Car[maxSize];
        front = -1;//ָ�����ͷ����frontָ�����ͷǰһ��λ��
        rear = -1;//ָ�����β ���������һ�����ݵ�λ��
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return rear == front;
    }

    //
    public void addQueue(Car car) {
        if (isFull()) {
            System.out.println("��������,���ܼ�������");
            return;
        }
        rear++;
        arr[rear] = car;
    }

    public Car getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�գ�����ȡ������");
            //return;   ���ﲻ��дreturn ��һ������쳣���Ѿ�������ֹ�� �κδ��붼����ִ����
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�գ�û�����ݿ�����ʾ����");
        }
        for (int i = front + 1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public Car headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�� û������");
        }
        return arr[front + 1];  //ע�����ﲻ���������һ��  front+1��һ����������0���괦
    }

    public int getSize() {
        return rear;
    }
}


class Car {

    private String num;
    private Date Atime;
    private Date Dtime;
    private int money;

    public Car() {
    }

    public Car(String num, Date atime, Date dtime, int money) {

        this.num = num;
        Atime = atime;
        Dtime = dtime;
        this.money = money;
    }


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getAtime() {
        return Atime;
    }

    public void setAtime(Date atime) {
        Atime = atime;
    }

    public Date getDtime() {
        return Dtime;
    }

    public void setDtime(Date dtime) {
        Dtime = dtime;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return
                "���ƺţ�" + num +
                        "\n����ʱ�䣺" + Atime +
                        "\n�뿪ʱ�䣺" + Dtime +
                        "\nͣ�����ã�" + money
                ;
    }
}