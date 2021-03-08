package hashmap;

import java.util.HashMap;

public class HashMapTest {


    public static void main(String[] args) {


        //无参的new hashmap并没有创建数组 看源码只是赋值加载因子
        //其实在基本的几个创建方法中都没有创建数组
        HashMap hashMap = new HashMap(16);
        hashMap.put(1,"1");
        hashMap.put(1,"1");
        hashMap.put(17,"2");



    }

}
