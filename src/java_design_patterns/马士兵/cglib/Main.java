package java_design_patterns.马士兵.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * CGLIB实现动态代理不需要接口  （底层用的也是ASM）  code generate library  代码生成
 * （ASM直接操作的是二进制码 可以直接把代买改掉 直接重写了  final修饰的都可以直接改掉）
 */
public class Main {
    public static void main(String[] args) {
        //Enhancer英文叫增强器的意思
        Enhancer enhancer = new Enhancer();
        //将Tank类设置为父类
        enhancer.setSuperclass(Tank.class);
        //相当于invocationhandler  会调用TimeMethodInterceptor中的intercept
        enhancer.setCallback(new TimeMethodInterceptor());
        //真正的代理生成
        Tank tank = (Tank) enhancer.create();
        //调用TimeMethodInterceptor中的intercept  执行时调用原来的方法返回
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    //第一个参数o也是生成的代理类对象
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //可以看出代理对象的父类就是Tank 所以cglib生成的代理对象就是被代理类的子类，，所以cglib代理不需要被代理的类实现接口
        //但是如果被代理的类是final修饰 就不能用cglib
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}

class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


