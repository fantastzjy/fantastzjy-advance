package leetcode.队列_栈_优先队列.TopK;

import java.util.*;

//解析见 https://mp.weixin.qq.com/s/HaP1dbofRTAn-XMlhtZn-g
//时空复杂度分析：
//        第一步是 O(n)，第三步是 nlog(k)，所以加在一起时间复杂度是 O(nlogk).
//        用了一个额外的 heap 和 map，空间复杂度是 O(n).
public class T692_前K个高频单词_练习 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2).toString());
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            Integer count = map.getOrDefault(word, 0);
            count++;
            map.put(word, count);
        }

        //建立小根堆
        PriorityQueue<Map.Entry<String, Integer>> que = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            que.offer(entry);
            if (que.size() > k) {
                que.poll();
            }
        }
        List<String> res = new ArrayList<>();

        while (!que.isEmpty()) {
            res.add(que.poll().getKey());
        }
        Collections.reverse(res);

        return res;

    }
}