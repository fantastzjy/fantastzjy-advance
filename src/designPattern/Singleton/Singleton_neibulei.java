package designPattern.Singleton;

/**
 * 静态内部类方式
 * JVM保证单例 一个类只会被加载一次 内部类不会在’外部类‘初始化时加载
 * （也就是说内明内部类Holder只会加载一次 ，并且会把静态内部类初始化 所以只会被初始化一次）
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Singleton_neibulei {
    private Singleton_neibulei() {
    }

    private static class Singleton_neibuleiHolder {
        private static Singleton_neibulei INSTANCE = new Singleton_neibulei();
    }

    public static Singleton_neibulei getInstance() {
        return Singleton_neibuleiHolder.INSTANCE;
    }

    public void m() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_neibulei.getInstance().hashCode());
            }).start();
        }
    }

}
