package fantastzjy.java_jvm.A_上篇_内存与垃圾回收.chapter05.src.com.atguigu.java2;

/**
 * 解析调用中非虚方法、虚方法的测试
 * <p>
 * invokestatic指令和invokespecial指令调用的方法称为非虚方法
 *
 * @author shkstart
 * @create 2020 下午 12:07
 */
class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

public class Son extends Father {
    public Son() {
        //invokespecial
        super();
    }

    public Son(int age) {
        //invokespecial
        this();
    }

    //不是重写的父类的静态方法，因为静态方法不能被重写！ 这个方法就是子类的
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private" + str);
    }

    public void show() {
        //invokestatic
        showStatic("atguigu.com");
        //invokestatic
        Father.showStatic("good!");
        //super.showStatic("good!");    为什么康师傅这样就不报错呢
        //invokespecial
        showPrivate("hello!");   //父类没有此方法 如果是private 不加this是invokespecial ，如果是public 不加指定的话就是 invokevirtual
        //invokespecial
        super.showCommon();

        //invokevirtual
        showFinal();//因为此方法声明有final，不能被子类重写，所以也认为此方法是非虚方法。
        //如果是super.showFinal();  此时是明确的，更是invokespecial   是非虚方法

        //虚方法如下：
        //invokevirtual
        //因为他不是final的 子类中也可能有该方法，
        // 此时没有显式的super.showCommon();,,所以不能确定下来是父类的还是子类的，虽然子类没有该方法但是继承了父类的，并不能判定子类是否重写了该方法
        showCommon(); //在运行时才能确定是父类的方法

        info();   //自己定义的，同样是没有指定，所以是虚方法

        MethodInterface in = null;
        //invokeinterface //MethodInterface是接口，在调用的时候 不能找到其实现类
        in.methodA();
    }

    public void info() {

    }

    public void display(Father f) {
        f.showCommon();
    }

    //总结 子类继承父类的方法 如果是子类自己有，父类没有，private就是invokespecial ，
    //                                            public就是invokevirtual
    //                          子类没有，就默认继承了父类 如果没有this或者super 就是 invokevirtual
    //总之就是编译时能不能确定到具体的    invokevirtual是运行时才可以知道是具体的哪一个，所以是晚绑定方法
    public static void main(String[] args) {
        Son so = new Son();
        so.show();
    }
}

interface MethodInterface {
    void methodA();
}
