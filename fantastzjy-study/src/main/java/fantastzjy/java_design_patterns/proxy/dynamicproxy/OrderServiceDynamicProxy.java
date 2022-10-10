package fantastzjy.java_design_patterns.proxy.dynamicproxy;

import fantastzjy.java_design_patterns.proxy.Order;
import fantastzjy.java_design_patterns.proxy.OrderService;
import fantastzjy.java_design_patterns.proxy.OrderServiceImpl;
import fantastzjy.java_design_patterns.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by geely
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind() {
        Class cls = target.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        beforeMethod(argObject);
        Object object = method.invoke(target, args);
        afterMethod();
        return object;
    }

    private void beforeMethod(Object obj) {
        int userId = 0;
        System.out.println("动态代理 before code");
        if (obj instanceof Order) {
            Order order = (Order) obj;
            userId = order.getUserId();
        }
        int dbRouter = userId % 2;
        System.out.println("动态代理分配到【db" + dbRouter + "】处理数据");

        //todo 设置dataSource;
        DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
    }

    private void afterMethod() {
        System.out.println("动态代理 after code");
    }

    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        OrderService orderServiceDynamicProxy = (OrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }

}
