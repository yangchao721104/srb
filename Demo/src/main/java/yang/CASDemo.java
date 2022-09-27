package yang;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. CAS是什么？ ====》compareAndSet
 *      比较并交换
 * @author yang
 * @date 2022/7/26 15:24
 */
public class CASDemo {

    @Bean
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1",12131312);
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data:" + atomicInteger.get());

        atomicInteger.getAndIncrement();
        new HashMap<>().put(1,1);
    }


}
