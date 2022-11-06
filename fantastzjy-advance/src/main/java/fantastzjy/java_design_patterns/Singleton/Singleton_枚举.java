package fantastzjy.java_design_patterns.Singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化。
 * 缺点：将一个类搞成了枚举，不容易区分
 */
public enum Singleton_枚举 {
    INSTANCE("", "");

    Singleton_枚举(String k1, String k2) {
        this.k1 = k1;
        this.k2 = k2;
    }

    private String k1;
    private String k2;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_枚举.INSTANCE.k1);
            }).start();
        }
    }
}