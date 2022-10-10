package fantastzjy.java_jvm.B_中篇_字节码与类的加载.chapter01_Class文件结构.java1;

/**
 * @author shkstart
 * @create 2020-09-05 18:53
 */
public class SeniorDemo {
    private int num = 1;
    public final String info = "atguigu";
    boolean[] counts;

    public SeniorDemo() {

    }

    public SeniorDemo(int count) {
        this.counts = new boolean[count];
    }

    public String getInfo() {
        return info;
    }

    public void addNum(int n) {
        num += n;
        System.out.println(num);
    }
}
