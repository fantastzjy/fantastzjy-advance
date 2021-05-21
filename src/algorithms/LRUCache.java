package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache lruCacheDemo = new LRUCache(3);

        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4, 1);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        System.out.println(lruCacheDemo.map.keySet());

    }


    // 1.构造一个node节点作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        //初始化  将
        public Node() {
            //构造函数 对node进行初始化
            this.prev = this.next = null;

        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

    }

    // 2.构建一个虚拟的双向链表,,里面安放的就是我们的Node
    //双线链表需要输入kv 是因为node这个类 是个泛型类
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        //初始化   将链表的首尾连接起来 才形成了一个链表
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            //注意顺序
            //由于是在投不添加，所以要根据头节点将原来的第二个节点的前一个节点设置为当前节点
            head.next.prev = node;
            head.next = node;
            //tail.prev = node;  不是这个 添加到头  和尾没关系
        }

        // 4.删除节点
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        // 5.获得最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }


    //LRUCache属性
    private int capacity;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value; //要得到的是值
    }


    public void put(int key, int value) {
        //先不用判断是否空间已满 先判断是否已经包含该node
        //注意这里的逻辑 如果有了 就更新 如果没有 就先判断空间是否还有  没有的话先删除掉一个  注意else里面的逻辑
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            //上一步更新完之后一定要再放进去
            map.put(key, node);
            //不仅要把map更新 也要把链表更新
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (capacity == map.size()) {
                //两个地方都要删除，注意顺序
                //map.remove(doubleLinkedList.getLast());  注意 是根据key删除的
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);

            }
            //新增一个
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

}
