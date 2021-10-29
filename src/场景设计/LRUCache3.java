package 场景设计;

import java.util.HashMap;

public class LRUCache3 {

    public static void main(String[] args) {

        LRUCache3 lruCacheDemo = new LRUCache3(3);

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
        lruCacheDemo.put(6, 1);
        System.out.println(lruCacheDemo.map.keySet());

    }


    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;


        public Node() {
        }

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    class DoubleLinked<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        DoubleLinked() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
            //node.prev = null;    //这俩不用置为null吧！！！！
            //node.next = null;
        }

        public Node<K, V> getLast() {
            return tail.prev;
        }
    }

    private int capacity;
    private HashMap<Integer, Node<Integer, Integer>> map;
    private DoubleLinked<Integer, Integer> doubleLinked;  //治理制定integer是因为 每个里面node节点需要制定类型

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinked = new DoubleLinked<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinked.remove(node);
        doubleLinked.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinked.remove(node);
            doubleLinked.addHead(node);
        } else {
            if (map.size() == capacity) {
                Node<Integer, Integer> last = doubleLinked.getLast();
                doubleLinked.remove(last);
                map.remove(last.key);
                System.out.println("移除" + last.value + " mapsize" + map.size());
            }
            Node<Integer, Integer> newnode = new Node<>(key, value);
            map.put(key, newnode);
            doubleLinked.addHead(newnode);
        }
    }
}