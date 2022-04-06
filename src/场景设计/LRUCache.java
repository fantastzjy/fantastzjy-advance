package 场景设计;

import java.util.HashMap;
import java.util.Map;

//原理概述
public class LRUCache {


    public static void main(String[] args) {

        LRUCache_ lruCacheDemo = new LRUCache_(3);
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

    //总体思考：    Node<K,V>   双向链表的节点  有前后指针       要有一个空参的构造方法
    //              DoubleLinked<K,V>    双向链表    get方法的传参直接就是Node  因为是从map中取出来的node来get的
    //                                含有方法：   remove  addHead    getLast


    //在初始化双向链表时  要写个无参构造器  进行首尾相连  形成一个链表    那所以node类中 要含有一个无参构造器
    //get方法   就直接从map中获取    然后同步更新链表中
    //put方法   若map中由该值  更新map与list     不含则判断是否容量已满


    // 1.构造一个node节点作为数据载体
    //链表的节点是双向链表的节点！！！所以有前后指针！！！！
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        //初始化  如果没有的话 在new Node时 不能使用空的构造方法，，虽然字节码文件中由无参构造函数
        public Node() {

        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            //this.prev = this.next = null;  字段属性会默认初始值
        }

    }

    // 2.双向链表
    //双线链表需要输入 kv 是因为node这个类 是个泛型类
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


        public void addHead(Node<K, V> node) {
            //先对当前链表的前后指针赋值，在对插入处的节点前后做处理

            node.next = head.next;
            node.prev = head;
            node.next.prev = node;//等效于  head.next.prev = node；
            head.next = node;

        }

        // 4.删除节点   这里不用再遍历寻找了 因为传进来的就是在map里面存的一模一样的！！！！！！
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            //node.prev = null;    //这俩不用置为null吧！！！！
            //node.next = null;
        }

        // 5.获得最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }


    //LRUCache属性
    //指定大小
    private int capacity;
    //负责hash查找
    Map<Integer, Node<Integer, Integer>> map;
    //负责存储
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
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