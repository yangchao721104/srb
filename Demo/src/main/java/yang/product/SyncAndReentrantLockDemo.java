package yang.product;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * @date 2022/7/31 14:27
 * a打印，b打印，c打印
 */

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print1(){
        lock.lock();
        try {
            //判断
            while (number != 1){
                c1.await();
            }
            //干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            //通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print6(){
        lock.lock();
        try {
            //判断
            while (number != 2){
                c2.await();
            }
            //干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            //通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print11(){
        lock.lock();
        try {
            //判断
            while (number != 3){
                c3.await();
            }
            //干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            //通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                shareResource.print1();
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                shareResource.print6();
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                shareResource.print11();
            }
        }, "CCC").start();
    }

}
