package hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class HashMapTest {


    public static void main(String[] args) {


        //无参的new hashmap并没有创建数组 看源码只是赋值加载因子
        //其实在基本的几个创建方法中都没有创建数组
        HashMap hashMap = new HashMap(16);
        hashMap.put(1, "1");
        hashMap.put(1, "1");
        hashMap.put(17, "2");
        hashMap.put(17, null);
        //Iterator iterator = hashMap..iterator();
        //
        //while (iterator.hasNext()) {
        //    Object next = iterator.next();
        //    System.out.println(next);
        //}


        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        //编写的时候为null不会提示 当运行时会提醒空指针异常
        //objectObjectHashtable.put(111, null);

    }

}
