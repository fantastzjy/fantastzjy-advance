package Leetcode.demo;


import com.alibaba.fastjson2.JSON;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: Java原理相关.Java开发手册
 * @ClassName: CollectionDemo
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-7-29 10:21
 * @Description:
 */
public class CollectionDemo {

    public static void main(String[] args) {

        //2、
        List<String> list1 = new ArrayList<>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");

        //java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
        //ArrayList<String> strings1 = (ArrayList<String>) list1.subList(0, 2);

        //可以，
        List<String> strings2 = list1.subList(0, 2);


        //subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList ，而是ArrayList 的一个视图
        //对于 SubList 子列表的所有操作最终会反映到原列表上。
        strings2.remove(0);


        //3、
        //在 subList 场景中，高度注意对“原集合元素个数的修改”，会“导致子列表”的遍历、增加、删除均会产生 ConcurrentModificationException 异常。


        //4、

        List<String> list4 = new ArrayList<>();
        list4.add("0");
        list4.add("1");
        list4.add("2");
        list4.add("3");

        //若数组长度大于集合，大于部分置为null
        //String[] strings4 = new String[7];

        //若数组长度小于集合，会新建一个数组对象（需赋值引用： String[] strings = list4.toArray(strings4);），本想要赋值的对象值为null   ：All elements are null
        //String[] strings4 = new String[1];

        String[] strings4 = new String[list4.size()];

        list4.toArray(strings4);


        //反例：直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现 ClassCastException 错误。
        //Object[] objects = list4.toArray();
        //String[] objects1 = (String[]) objects;

        //5、
        String[] str = new String[]{"you", "wu"};
        List list5 = Arrays.asList(str);

        //第一种情况：list.add("yangguanbao"); 运行时异常。
        //list5.add("yangguanbao");

        //第二种情况：str[0] = "gujin"; 那么 list.get(0)也会随之修改
        str[0] = "gujin";

        System.out.println(JSON.toJSONString(list5));


        //6  todo
        //ArrayList<? extends Object> lists = new ArrayList<? extends Object>();


        //7
        //【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator方式，如果并发操作，需要对 Iterator 对象加锁。


        //正例：
        //Iterator<String> iterator = list.iterator();
        //while (iterator.hasNext()) {
        //    String item = iterator.next();
        //    if (删除元素的条件) {
        //        iterator.remove();
        //    }
        //}
        //反例：
        //List<String> list = new ArrayList<String>();
        //list.add("1");
        //list.add("2");
        //for (String item : list) {
        //    if ("1".equals(item)) {
        //        list.remove(item);
        //    }
        //}
        //说明：以上代码的执行结果肯定会出乎大家的意料，那么试一下把“1”换成“2”，会是同样的结果吗？

        //奇怪 换成2会报错     “1” “2”  在集合中的顺序是1 2 但是边立柱红删除1不会报错 删除2会报错
        //若增加多个元素 都是删除倒数第二个元素不会报错！！！！ why？  todo
        List<String> list7 = new ArrayList<String>();
        list7.add("1");
        list7.add("2");
        list7.add("3");
        list7.add("4");
        //for (String item : list7) {
        //    if ("1".equals(item)) {
        //        list7.remove(item);
        //    }
        //}


        //8 【强制】 在 JDK7 版本及以上，Comparator 要满足如下三个条件，不然 Arrays.sort，Collections.sort 会报 IllegalArgumentException 异常。
        //   说明：三个条件如下
        //   1） x，y 的比较结果和 y，x 的比较结果相反。
        //   2） x>y，y>z，则 x>z。
        //   3） x=y，则 x，z 比较结果和 y，z 比较结果相同


        //反例：下例中没有处理相等的情况，实际使用中可能会出现异常：
        //      new Comparator<Student>() {
        //          @Override
        //          public int compare(Student o1, Student o2) {
        //              return o1.getId() > o2.getId() ? 1 : -1;
        //          }
        //      };




        //9  集合初始化时，指定集合初始值大小。
        //说明：HashMap 使用 HashMap(int initialCapacity) 初始化，
        //正例：initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即 loaderfactor）默认为 0.75，如果暂时无法确定初始值大小，请设置为 16（即默认值）。
        //反例：HashMap 需要放置 1024 个元素，由于没有设置容量初始大小，随着元素不断增加，容量 7 次被迫扩大，resize 需要重建 hash 表，严重影响性能。


        //10
        //推荐】使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。
        //说明：
        //     keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出key 所对应的 value。
        //     而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效率更高。如果是 JDK8，使用 Map.foreach 方法。

        //正例：values()返回的是 V 值集合，是一个 list 集合对象；keySet()返回的是 K 值集合，是一个 Set 集合对象；entrySet()返回的是 K-V 值组合集合。


        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");

        //values()返回的是 V 值集合
        map.values();

        //不推荐
        // 若获取 KV ，  keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出key 所对应的 value。
        //若只获取 K 可以使用
        for (String k : map.keySet()) {
            String v = map.get(k);
            System.out.println("K:V >>> " + k + ":" + v);
        }

        //推荐
        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }

        // 如果是 JDK8，使用 Map.foreach 方法。
        map.forEach((k, v) -> {
            System.out.println("K:V >>> " + k + ":" + v);
        });


        //11. 【推荐】高度注意 Map 类集合 K/V 能不能存储 null 值的情况，如下表格：

        //   集合类                Key              Value              Super              说明
        //   Hashtable         不允许为 null     不允许为 null      Dictionary           线程安全
        //   ConcurrentHashMap 不允许为 null     不允许为 null      AbstractMap      锁分段技术（JDK8:CAS）
        //   TreeMap           不允许为 null       允许为 null      AbstractMap          线程不安全          ****
        //   HashMap            允许为 null        允许为 null      AbstractMap          线程不安全

        //反例： 由于 HashMap 的干扰，很多人认为 ConcurrentHashMap 是可以置入 null 值，而事实上，存储 null 值时会抛出 NPE 异常。 *****


        //12. 【参考】合理利用好集合的有序性(sort)和稳定性(order)，避免集合的无序性(unsort)和不稳定性(unorder)带来的负面影响。
        //     说明：有序性是指遍历的结果是按某种比较规则依次排列的。稳定性指集合每次遍历的元素次序是一定的。
        //      如：ArrayList 是 order/unsort；HashMap 是 unorder/unsort；TreeSet 是order/sort。



        //13. 【参考】利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的contains 方法进行遍历、对比、去重操作。



        System.out.println();


    }


}
