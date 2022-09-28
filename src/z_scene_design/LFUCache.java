package z_scene_design;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    //记录值
    HashMap<Integer, Integer> keyToValue;
    //记录频率
    HashMap<Integer, Integer> keyToFreq;
    //记录个个频率有哪些对应的key ---方便 删除频率最低的  value为linkedlist 有顺序 频率一样时 方便从把最老的删除
    HashMap<Integer, LinkedHashSet<Integer>> freqToKey;

    int capacity;
    //记录系统频率最低的值 初始值为0
    int minFreq;


    public static void main(String[] args) {
        //["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        //       [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        System.out.println(lfuCache.minFreq);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.minFreq);
        System.out.println(lfuCache.get(1));
        System.out.println(";;;");
        System.out.println(lfuCache.minFreq);
        lfuCache.put(3, 3);
        System.out.println(lfuCache.minFreq);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.minFreq);
        System.out.println(lfuCache.get(3));
        System.out.println("111");
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    //初始化
    public LFUCache(int capacity) {
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();  //注意这里还是new java原理相关.hashmap
        this.capacity = capacity;
        this.minFreq = 0;
    }


    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        //如果存在
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            //更新freq
            increaseFreq(key);
            return; //插入之后忘记直接退出了  导致该元素插入两次频率也高了
        }

        //不存在
        //容量不足删除
        if (keyToValue.size() >= this.capacity) {
            removeLeastFreq();
        }

        //插入
        //更新kv
        keyToValue.put(key, value);
        //更新kf
        keyToFreq.put(key, 1);

        //更新fk 注意这里面的操作！！！！！！！！！*************
        //不存在就创建 然后加入当前的
        freqToKey.putIfAbsent(1, new LinkedHashSet<>());  //里面不要传值不然重复了，new LinkedHashSet<>(key)！！！！！！！！
        freqToKey.get(1).add(key);
        //更新 minfreq 加入一个新的后 最小的一定是1
        this.minFreq = 1;
    }


    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }


    private void removeLeastFreq() {

        LinkedHashSet<Integer> leastFreqKey = freqToKey.get(this.minFreq);
        //获取到了最老的元素  注意这里的写法！！！！！！！！********
        Integer deleteKey = leastFreqKey.iterator().next();

        //更新kv
        keyToValue.remove(deleteKey);
        //更新kf
        keyToFreq.remove(deleteKey);

        //更新fk   这里  才开始写的是    freqToKey.remove(deleteKey);   当deleteKey=2时  把 freq==2 key=1 误删了
        //freqToKey.get(this.minFreq).remove(deleteKey);
        leastFreqKey.remove(deleteKey);   //写成这样就保险了

        if (leastFreqKey.isEmpty()) {
            freqToKey.remove(this.minFreq);
        }
        //为什么没有再设置最小的频率值？？？？？？？
        //因为只有再添加没有的元素并且容量慢的时候才会删除元素  新添加的元素的频率就是最小的 为1  在put方法中会设置的

    }


    private void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);

        //更新kf
        keyToFreq.put(key, freq + 1);

        // 更新fk
        freqToKey.get(freq).remove(key);

        //不存在就创建 然后加入当前的
        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKey.get(freq + 1).add(key);

        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            //如果是空的了才把最小值+1  要在这个判断为空的里面 进行判断添加
            if (freq == this.minFreq) {
                this.minFreq = this.minFreq + 1;
            }
        }
    }


}
