package Java_原理相关.juc包.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 组合式的异步编程:
 * 通过callable的实现
 * 可以同时对人工和材料费用进行计算，然后在主线程中获得费用并且进行计算
 * 1 get()会阻塞主线程的执行
 * 2 对于同一个任务，多条线程反复执行，只执行一边
 * 3 如果要反复执行同一项任务，需要再新建一个任务对象，然后新建线程来执行
 */
public class MyCallable implements Callable<Double> {

    public String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public Double call() throws Exception {
        // throws Exception   这里要抛出异常，不然继承的方法里面都要抛出异常
        Double price = 0d;

        if (productName.equals("人工")) {
            // 计算人工成本
            Thread.sleep(2000);
            System.out.println("正在计算人工成本");//调用资源类
            price = 12.0d;
        }

        if (productName.equals("材料")) {
            // 计算材料成本
            Thread.sleep(3000);
            System.err.println("正在计算材料成本");//调用资源类
            price = 11.0d;
        }
        return price;
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 工程成本核算问题
        System.out.println("开始核算工程成本");

        // 一条线程计算人工成本
        MyCallable myCallable1 = new MyCallable();// 自定义返回结果
        myCallable1.setProductName("人工");
        FutureTask<Double> futureTask1 = new FutureTask<Double>(myCallable1);
        new Thread(futureTask1).start();

        // 一条线程计算材料成本
        MyCallable myCallable2 = new MyCallable();// 自定义返回结果
        myCallable2.setProductName("材料");
        FutureTask<Double> futureTask2 = new FutureTask<Double>(myCallable2);
        new Thread(futureTask2).start();


        // 主线程计算总成本    注意使用FutureTask的名字获取get
        Double rengong = futureTask1.get();
        Double cailiao = futureTask2.get();

        //如果想在计算一遍材料的成本是不可以的，一条线不会去重复执行
        new Thread(futureTask2).start();
        Double cailiao2 = futureTask2.get();


        // 再创建一个callable的任务才可以
        //T05_MyCallable myCallable3 = new T05_MyCallable();// 自定义返回结果
        //myCallable3.setProductName("材料");
        //FutureTask<Double> futureTask3 = new FutureTask<Double>(myCallable3);
        //new Thread(futureTask3).start();// 再启动一条材料线程
        //futureTask3.get();

        System.out.println("人工成本为 \t" + rengong);
        System.out.println("材料成本为 \t" + cailiao);
        System.out.println("总成本为 \t" + (rengong + cailiao));

    }


}
