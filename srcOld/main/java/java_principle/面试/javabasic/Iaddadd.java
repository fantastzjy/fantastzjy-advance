package java_principle.面试.javabasic;

public class Iaddadd {
    public static void main(String[] args) {
        int i = 7;

        int j = i++;

        int m = 7;
        int n = ++m;
        System.out.println();
    }

    //执行+1 操作是给局部变量表的值+1  如果放入操作数栈就不会影响到原值
    //int j = i++ ;    取出值放入操作数栈  局部变量表中的i+1  再把操作数栈中的值放入j
    //int j = i++ ;    局部变量表中的值+1  取出值放入操作数栈    再把操作数栈中的值放入j
}




