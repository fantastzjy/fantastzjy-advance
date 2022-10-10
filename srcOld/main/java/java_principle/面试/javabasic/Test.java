package java_principle.面试.javabasic;

import java.math.BigDecimal;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        //Integer x = 3;
        //Integer y = 3;
        //System.out.println(x == y);// true
        //Integer a = new Integer(3);
        //Integer b = new Integer(3);
        //System.out.println(a == b);//false
        //System.out.println(a.equals(b));//true


        //BigDecimal介绍

        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x); /* 0.1 */
        System.out.println(y); /* 0.1 */
        System.out.println(Objects.equals(x, y)); /* true */


        BigDecimal m = new BigDecimal("1.255433");
        //BigDecimal.ROUND_HALF_DOWN 就是四舍五入
        BigDecimal n = m.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.255





        //Arrays.asList()使用指南
        System.out.println("Arrays.asList()使用指南");
        String[] myArray = {"aaa", "bbb", "ccc"};
        List<String> strings = Arrays.asList(myArray);
        //上面两个语句等价于下面一条语句
        //List<String> myList = Arrays.asList("Apple","Banana", "Orange");
        System.out.println(strings);
        System.out.println(strings.get(0)); //aaa
        //strings.add("ddd");  异常 java.lang.UnsupportedOperationException

        //总结1
        //传递的数组必须是对象数组，而不是基本类型。
        //Arrays.asList()是泛型方法，传入的对象必须是对象数组。

        //int[] myArray1 = {1, 2, 3};
        //List myList = Arrays.asList(myArray1);
        //System.out.println(myList.size());//1
        //System.out.println(myList.get(0));//数组地址值
        //System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        //int[] array = (int[]) myList.get(0);
        //System.out.println(array[0]);//1

        //对以上问题解释
        //当传入一个‘原生数据类型数组’时，Arrays.asList() 的真正得到的参数就不是数组中的元素，而是数组对象本身！此时List 的唯一元素就是这个数组，这也就解释了上面的代码。
        //我们使用包装类型数组就可以解决这个问题。
        //Integer[] myArray = {1, 2, 3};

        //总结2
        //使用集合的修改方法:add()、remove()、clear()会抛出异常。

        //List myList2 = Arrays.asList(1, 2, 3);
        //myList2.add(4);//运行时报错：UnsupportedOperationException
        //myList2.remove(1);//运行时报错：UnsupportedOperationException
        //myList2.clear();//运行时报错：UnsupportedOperationException

        //Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
        //System.out.println(myList2.getClass());//class java.util.Arrays\$ArrayList

        //总结3
        //如何正确的将数组转换为ArrayList?
        //最简便的方法(推荐)
        ArrayList<String> strings1 = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));
        System.out.println(strings1);
        strings1.add("dd");
        System.out.println(strings1);


        //Collection.toArray()方法使用的坑&如何反转数组
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);

        System.out.println(list);
        //list.toArray使用的前提是  Arrays.asList(s); 变成了List形式
        s = list.toArray(new String[0]);//没有指定类型的话会报错
        for (String s1 : s) {
            System.out.println(s1);
        }

        //上面 由于JVM优化，new String[0]作为Collection.toArray()方法的参数现在使用更好，
        // new String[0]就是起一个模板的作用，指定了返回数组的类型，
        // 0是为了节省空间，因为它只是为了说明返回的类型

        //反转数组 没有返回值，直接参数地址上的值进行反转操作
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("z_examination");
        list1.add("www");
        list1.add("rrr");
        System.out.println("反转数组前" + list1.toString());
        Collections.reverse(list1);
        System.out.println("反转数组后" + list1.toString());


        List<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list3.add(i);
        }
        //不要在 foreach 循环里进行元素的 remove/add 操作   要用迭代器
        //for (Integer integer : list3) {
        //    list3.remove(integer);
        //}

        Iterator<Integer> iterator = list3.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 1 || next == 2) {
                iterator.remove();
            }
        }

        //list3.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
        System.out.println(list3); /* [1, 3, 5, 7, 9] */


        //如果要进行remove操作，可以调用迭代器的 remove方法而不是集合类的 remove 方法。
        // 因为如果列表在任何时间从结构上修改创建迭代器之后，以任何方式除非通过迭代器自身remove/add方法，
        // 迭代器都将抛出一个ConcurrentModificationException,这就是单线程状态下产生的 fail-fast 机制。


        LinkedList<Object> objects = new LinkedList<>();

        //ArrayQueue<Object> objects1 = new ArrayQueue<>();
        Stack stack = new Stack();
        ArrayDeque arrayDeque = new ArrayDeque();


    }


}
