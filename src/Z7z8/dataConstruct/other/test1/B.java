package Z7z8.dataConstruct.other.test1;

public class B {
    private int i;
    float j;
    protected int y;
    public double k;
}

class B1 extends B{
    public void m() {
//        int n=i;  // [1]错误 i在B中被private修饰，private修饰的属性以及方法只能被该类的对象访问，其子类不能访问，因B1是B的子类 所以此处错误
//        double x=y+k;//[2] 正确 y被protected修饰，protected修饰的属性以及方法只能被类本身的方法及子类访问，因B1是B的子类，所以y可被访问。
                                //k被public修饰在哪里都可以访问 此处也可访问   所以[2]正确
    }
}
