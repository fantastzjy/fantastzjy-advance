package Java原理相关.接口与抽象类;

abstract class MyAbstractclass {
    public abstract void sd();
    //写方法体不能加abstract
    //public abstract void d(){
    //
    //};

    public void s() {
        System.out.println();

    }

    ;
}

public class Abstractclass {

    //抽象类不能实例化但是可以通过匿名内部类的方式实例化
    public static void main(String[] args) {
        //MyAbstractclass myAbstractclass = new MyAbstractclass(){};  //如果抽象类中由抽象方法会报错 没有的话不会报错
        //如果有抽象方法必须重写，具体的方法不用重写
        MyAbstractclass myAbstractclass = new MyAbstractclass() {
            @Override
            public void sd() {

            }

        };
    }
}
