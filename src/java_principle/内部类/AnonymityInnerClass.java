package java_principle.内部类;

//匿名内部类 的用法
public class AnonymityInnerClass {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        //1.这里利用了局部内部类
        class RedLight implements Light {
            public void shine() {
                System.out.println("shine in red");
            }
        }
        lamp.on(new RedLight());
        //2.这里利用了匿名内部类，没有类名，直接去new，去覆盖方法就OK
        lamp.on(new Light() {
            public void shine() {
                System.out.println("shine in yellow");
            }
        });
    }
}

interface Light {
    void shine();
}

class Lamp {
    public void on(Light light) {
        light.shine();
    }
}