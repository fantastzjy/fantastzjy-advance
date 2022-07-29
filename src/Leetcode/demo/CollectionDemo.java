package Leetcode.demo;

import com.alibaba.fastjson2.JSON;

import java.util.*;

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


        //8


        //9

        //10
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");

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


        System.out.println();


    }




}
