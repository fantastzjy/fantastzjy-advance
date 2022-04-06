package 场景设计;


import java.util.HashMap;
import java.util.Map;

//原理概述
public class LRUCache_ {

    //总体思考


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


    class Node<K, V> {

        K key;
        V val;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
        }

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }


    }


    class DoubleLinked<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinked() {
            this.head = new Node<>();  //上面必须写个空参构造方法这里才能这样写
            this.tail = new Node<>();

            this.head.next = tail;
            this.tail.prev = head;

        }

        public void addHead(Node<K, V> node) {

            node.next = head.next;
            node.prev = head;

            node.next.prev = node;
            head.next = node;
        }

        public void remove(Node<K, V> node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node getLast() {
            return tail.prev;
        }

    }


    int capatity;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinked list;

    public LRUCache_(int capatity) {
        this.capatity = capatity;
        this.map = new HashMap<>();
        this.list = new DoubleLinked();
    }


    public int get(int val) {

        if (!map.containsKey(val)) {
            return -1;
        }

        Node<Integer, Integer> node = map.get(val);
        list.remove(node);
        list.addHead(node);

        return node.val;
    }

    public void put(int key, int val) {

        if (map.containsKey(val)) {
            Node<Integer, Integer> node = map.get(val);
            node.val = val;
            map.put(key, node);
            list.remove(node);
            list.addHead(node);
        } else {

            if (map.size() == capatity) {
                Node<Integer, Integer> last = list.getLast();
                int lastval = last.val;
                map.remove(lastval);
                list.remove(last);

            }

            Node currnode = new Node(key, val);
            map.put(key, currnode);
            list.addHead(currnode);

        }

    }


}