package yang.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yang
 * @date 2022/7/31 12:48
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("1",1);

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("e"));
        blockingQueue.remove();

        System.out.println(blockingQueue.add("e"));
    }
}
