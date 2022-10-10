package java_principle.Java开发手册.并发处理;

import java.util.Random;

/**
 * @Package: Java原理相关.Java开发手册.并发处理
 * @ClassName: demo
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-8-4 9:50
 * @Description:
 */
public class demo {


    public static void main(String[] args) {
        System.out.println(new Random().nextInt(4));
        System.out.println(new Random().nextDouble());
        System.out.println(new Random().nextLong());
        System.out.println(new Random().nextBoolean()) ;

    }


}