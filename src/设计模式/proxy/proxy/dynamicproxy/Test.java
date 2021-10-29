package 设计模式.proxy.proxy.dynamicproxy;


import 设计模式.proxy.proxy.IOrderService;
import 设计模式.proxy.proxy.Order;
import 设计模式.proxy.proxy.OrderServiceImpl;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
