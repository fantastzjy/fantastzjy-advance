package juc.thread;

import java.util.concurrent.Callable;

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

}
