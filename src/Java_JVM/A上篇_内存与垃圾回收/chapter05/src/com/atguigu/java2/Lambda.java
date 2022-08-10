package Java_JVM.A上篇_内存与垃圾回收.chapter05.src.com.atguigu.java2;

/**
 * 体会invokedynamic指令
 * @author shkstart
 * @create 2020 下午 3:09
 */
@FunctionalInterface
interface Func {
    public boolean func(String str);
}

public class Lambda {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        Func func = s -> {
            return true;
        };

        lambda.lambda(func);

        lambda.lambda(s -> {
            return true;
        });
    }
}

