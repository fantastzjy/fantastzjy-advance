package fantastzjy.leetcode.队列_栈_优先队列.TopK;

import java.util.*;

//解析见 https://mp.weixin.qq.com/s/HaP1dbofRTAn-XMlhtZn-g
//时空复杂度分析：
//        第一步是 O(n)，第三步是 nlog(k)，所以加在一起时间复杂度是 O(nlogk).
//        用了一个额外的 heap 和 map，空间复杂度是 O(n).

//类似的场景题 输出销量高的前K个商品
public class T692_前K个高频单词 {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"I", "love", "I", "I", "love", "coding"}, 2).toString());
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Step 1  统计词频
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            //getOrDefault     如果不存在就返回参数传进去的默认值！！！！！好！！！
            Integer count = map.getOrDefault(word, 0);
            count++;
            map.put(word, count);
        }


        // Step 2  建立小根堆  定义比较规则  new Comparator 传进去的是基本比较单元   如果是数组  则是 int[] （题：前k个高频元素）
        //初始化为 k+1  为什么呢？  因为 存入queue时 是先放入在判断个数 如果个数超了就直接弹出来
        //Java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示。
        // 传入的比较器只是为了比较大小并不是排序  每次取出的都是最小值  所以最后需要反转      !!!!!!!!!!!!!!!!!!!!!!!!!!!
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(k + 1, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        //如果相等 按字母排序  如果不相等就大小排序
                        if (e1.getValue() == e2.getValue()) {
                            return e2.getKey().compareTo(e1.getKey());  // 因为字母后面的大  有要求按先后顺序  所以反过来写！！！！！！
                        }
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });

        // Step 3  将元素存入小根堆  并取出前k个
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }
        Collections.reverse(res);  //集合类的工具！！
        return res;
    }
}