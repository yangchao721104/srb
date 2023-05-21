package dealLock;

import sun.misc.Lock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @date 2022/8/1 12:14
 * 死锁是指两个或两个以上的进程在执行过程中
 * 因抢夺资源造成的一种互相等待的现象
 * 若无外力干涉，他们都无法推进下去
 */

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"\t 尝试获得"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t 尝试获得"+lockA);
            }

        }


    }
}

public class DealLockDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1",1);
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"threadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"threadBBB").start();
    }
}
