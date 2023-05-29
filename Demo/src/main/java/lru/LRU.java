package lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 手写lru
 * @author yang
 * @date 2023/5/24 14:12
 */
public class LRU {

    //map负责查找 负责构建双向链表
    //1 构造一个node节点，作为数据载体
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node(){
            this.prev = this.next = null;
        }

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;

        //构造方法
        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }
        //添加到头
        public void addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //删除节点
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        //获得最后一个节点
        public Node getLast(){
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRU(int cacheSize){
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){//更新
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if (map.size() == cacheSize){//坑位满了
                Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            //新增
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        lruDemo.put(1,"a");
        lruDemo.put(2,"b");
        lruDemo.put(3,"c");
        System.out.println(lruDemo.keySet());
        lruDemo.put(4,"d");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"d");
        System.out.println(lruDemo.keySet());
        lruDemo.put(3,"d");
        System.out.println(lruDemo.keySet());
        lruDemo.put(5,"d");
        System.out.println(lruDemo.keySet());
    }

}
