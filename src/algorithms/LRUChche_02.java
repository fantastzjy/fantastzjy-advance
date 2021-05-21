package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LRUChche_02 {

    class Node<K, V> {  //注意是尖括号 不是圆括号   如果是类的话直接就是{ }
        //int val;  是下面的kv
        K key;
        V value;

        Node<K, V> pre;
        Node<K, V> next;

        public Node() {
            next = pre = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = pre = null;
        }

    }

    class DoubleLinkedList<K, V> {
        Node head;
        Node tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;

        }
        //不需要有(传参的构造函数)
        //public DoubleLinkedList(Node<K, V> node) {
        //    node.next = tail;
        //    node.pre = head;
        //    head.next.pre = node;
        //    head.next = node;
        //}

        public void addHead(Node<K, V> node) {
            //node.next = tail;   这里写错了导致 测试用例不通过添加到头和tail没关系
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void remove(Node<K, V> node) {
            //node.pre.next = tail;  这一这是普通的删除 不是删除最后一个
            //tail.pre = node.pre;
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        public Node getLast() {  //不需要写成 Node<K,V>   ？？？、泛型补充！！！！！！
            return tail.pre;
        }

    }

    private int capacity;   //根据封装的特性  写成private比较好
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;  //里面要传入具体类型才可

    public LRUChche_02(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
    }

    //注意get不是删除
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //Node<Integer, Integer> node = map.get(key);
        //map.remove(node.value);
        //doubleLinkedList.remove(node);
        //return node.value;

        Node<Integer, Integer> node = map.get(key);
        //map.remove(node.value);
        doubleLinkedList.remove(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }


    //public void put(Node node) {
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            //更新node
            node.value = value;
            //更新map
            map.put(key, node);
            //更新链表
            doubleLinkedList.remove(node);
            doubleLinkedList.addHead(node);
        } else {
            ////如果小于 直接添加
            //if (map.size() < capacity) {
            //    Node node = new Node(key, value);
            //    map.put(key, node);
            //    doubleLinkedList.addHead(node);
            //} else {
            //    Node last = doubleLinkedList.getLast();
            //    doubleLinkedList.remove(last);
            //    map.remove(last.key);
            //
            //    Node node = new Node(key, value);
            //    map.put(key, node);
            //    doubleLinkedList.addHead(node);
            //
            //}

            //如果小于 直接添加    不管删掉再添加还是直接添加都要添加 所以添加的操作可以合并
            if (map.size() == capacity) {
                Node last = doubleLinkedList.getLast();
                doubleLinkedList.remove(last);
                map.remove(last.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            doubleLinkedList.addHead(node);


        }
    }


    public static void main(String[] args) {

        LRUChche_02 lruCacheDemo = new LRUChche_02(3);

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


}
