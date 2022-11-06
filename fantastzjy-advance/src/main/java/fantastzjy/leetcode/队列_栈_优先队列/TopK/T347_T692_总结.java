package fantastzjy.leetcode.队列_栈_优先队列.TopK;

public class T347_T692_总结 {

/*
T347_前K个高频元素 与  T692_前K个高频单词 相比就是需要比较的东西参数不同
高频元素是int类型    能用int 也可用 map
单词是string类型    只能用map存

统计的个数都是用的hashmap
存入队列时分别用的是int[] 和 Map.entery<integer,integer>
由于queue存入的类型是int[]  所以取出后直接加上角标就可以用！！！
queue.peek()[1] < count
queue.poll()[0]

int类型比较 直接相减即可
integer类型比较用compareTo
        统计单词时
                //如果相等 按字母排序  如果不相等就大小排序
                if (e1.getValue() == e2.getValue()) {
                    return e2.getKey().compareTo(e1.getKey());  // 因为字母后面的大  有要求按先后顺序  所以反过来写！！！！！！
                }
                return e1.getValue().compareTo(e2.getValue());

Entry 指的是-》 键值对

 */

}
