package 设计模式.proxy.staticproxy;


import 设计模式.proxy.OrderService;
import 设计模式.proxy.Order;
import 设计模式.proxy.OrderServiceImpl;
import 设计模式.proxy.db.DataSourceContextHolder;


public class OrderServiceStaticProxy {
    private OrderService orderService;

    public int saveOrder(Order order) {
        beforeMethod(order);

        orderService = new OrderServiceImpl();
        int result = orderService.saveOrder(order);

        afterMethod();
        return result;
    }

    private void beforeMethod(Order order){
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db"+dbRouter+"】处理数据");

        //todo 设置dataSource;

        DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
