package 设计模式.Singleton;

/**
 * 静态内部类方式
 * JVM保证单例 一个类只会被加载一次 内部类不会在’外部类‘初始化时加载
 * （也就是说内明内部类Holder只会加载一次 ，并且会把静态内部类初始化 所以只会被初始化一次）
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * static变量值在类加载的时候分配空间，以后创建类对象的时候不会重新分配。
 * 赋值的话，是可以任意赋值的
 */
public class Singleton_静态内部类 {

    private static class Singleton_neibuleiHolder {
        private static Singleton_静态内部类 INSTANCE = new Singleton_静态内部类();
    }

    public static Singleton_静态内部类 getInstance() {
        return Singleton_neibuleiHolder.INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_静态内部类.getInstance().hashCode());
            }).start();
        }
    }

}
