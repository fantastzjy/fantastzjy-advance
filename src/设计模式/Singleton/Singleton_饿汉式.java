package 设计模式.Singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证该对象仅仅被创建一次，保证线程安全简单实用，推荐使用!
 * 唯一缺点:不管用到与否,类装载时就完成实例化
 * （话说你不用的，你装载它干啥>
 */
public class Singleton_饿汉式 {
    private static Singleton_饿汉式 INSTANCE = new Singleton_饿汉式();

    private Singleton_饿汉式() {
    }

    public static Singleton_饿汉式 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Singleton_饿汉式 q1 = Singleton_饿汉式.getInstance();
        Singleton_饿汉式 q2 = Singleton_饿汉式.getInstance();
        System.out.println(q1 == q2);

    }

}
