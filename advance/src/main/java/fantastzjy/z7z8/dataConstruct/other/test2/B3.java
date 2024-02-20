package fantastzjy.z7z8.dataConstruct.other.test2;


import fantastzjy.z7z8.dataConstruct.other.test1.B;

public class B3 extends B {
    public void m() {
//        int n=y; //[3]  正确  y被protected修饰，protected修饰的属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。因B1是B的子类，所以y可被访问。
//        double x=j+k;//[4] 错误 j前面没有带权限修饰就是默认default ，只允许在同一个包中进行访问  而j在另一个包中 ，所以不能访问
    }
}
