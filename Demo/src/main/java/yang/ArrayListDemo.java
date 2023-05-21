package yang;

import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类线程不安全
 * arraylist
 * @author yang
 * @date 2022/7/27 15:12
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //java.util.ConcurrentModificationException

        HashSet<String> set = new HashSet<>();
        //解决方法1
//        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        //解决2：
//        CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }



//        Arrarylist();

    }

    private static void Arrarylist() {
        //故障现象
        //java.util.ConcurrentModificationException
        //并发争抢导致，参考我们的花名册争抢情况
        //一个人在写，另一个人争抢，导致数据不一致导致，并发修改异常
//        List<String> list = new ArrayList<>();

        //解决1:
        //Vector可以解决，加锁但是并发急剧下降
//        List<String> list = new Vector<>();
        //解决2:
//        List<Object> list = Collections.synchronizedList(new ArrayList<>())
        
        //解决3：
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        //写时复制
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
