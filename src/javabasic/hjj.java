package javabasic;

import java.util.*;

public class hjj {
    public static void main(String[] args) {

        int[] memo = new int[10];
        for (int i : memo) {
            System.out.print(i);
        }
        System.out.println();
        //Java会自动初始化数组

        Integer a = 100;//此处若使用new，则==值必为false

        Integer b = 100;

        System.out.println(a == b);//true

        Integer c = 150;

        Integer d = 150;

        System.out.println("-128-127 之外是" + (c == d));//false

        //注意 这个是个负值   -2147483648
        System.out.println(Integer.MAX_VALUE + 1);

        //可以为null
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(null);
        //System::out
        // (objects.toArray());
        System.out.println(objects.get(0));//null

        //可以为null
        LinkedList<Object> objects1 = new LinkedList<>();//LinkedList[Ljava.lang.Object;@14ae5a5
        objects1.add(null);
        System.out.println(objects.get(0));//null

        //   不   可以为null
        ArrayDeque<Object> objects2 = new ArrayDeque<>();
        //objects2.add(null);  // java.lang.NullPointerException
        System.out.println(objects.get(0));//null   如果是objects.get(1) 会NullPointerException

        //HashMap  键和值都可以为null
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);
        //hashmap为 [null=null]   如果传入的是null  只是在计算hash的时候赋值为0计算 并不是存入的就是0
        System.out.println("hashmap为 " + hashMap.entrySet());

        //Hashtable  键和值都不能为null
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        //hashtable.put(1, null);java.lang.NullPointerException
        //hashtable.put(null, null);java.lang.NullPointerException
        System.out.println("hashtable为" + hashtable.get(1)); //null

    }
}
