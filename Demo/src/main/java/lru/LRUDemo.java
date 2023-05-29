package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yang
 * @date 2023/5/22 0:13
 */
public class LRUDemo<K,V> extends LinkedHashMap<K,V> {

    private int capacity;//缓存坑位

    public LRUDemo(int capacity){
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
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
