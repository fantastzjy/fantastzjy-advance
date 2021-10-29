package 设计模式.AAAmashibing.spring.v1;

public class TimeProxy {

    public void before() {
        System.out.println("method start.." + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method stop.." + System.currentTimeMillis());
    }

}
