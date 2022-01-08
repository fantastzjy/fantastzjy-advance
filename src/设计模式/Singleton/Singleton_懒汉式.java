package 设计模式.Singleton;

/**
 * 懒汉式   DCL
 * 加锁防止高并发
 * 双重验证方式 避免被实例化多次
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Singleton_懒汉式 {
    //如果不加 volatile  会在没有初始化就返回 实例instance
    // 通过volatile保证线程可见性和有序性。

    private static volatile Singleton_懒汉式 INSTANCE;

    public static Singleton_懒汉式 getInstance() {
        //双重验证
        // 如果 未初始化 就进去初始化   已初始化 就直接返回
        if (INSTANCE == null) {
            //对类加锁
            synchronized (Singleton_懒汉式.class) {
                //synchronized   并发情况下 会有多个线程请求获取锁  进来之后再判断下 保证只有一个线程初始化
                if (INSTANCE == null) {
                    INSTANCE = new Singleton_懒汉式();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("懒汉式创建实例hashcode： " + Singleton_懒汉式.getInstance().hashCode());
            }).start();
        }
    }
}
