package yang;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendEmail");
    }


    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke set()");
        }finally {
            lock.unlock();
        }
    }
}


/**
 * @author yang
 * @date 2022/7/27 21:46
 *
 * ReenterLock
 * 可重入锁（也叫递归锁）
 * 指的是同一线程外层函数获得锁之后，内层递归函数任然能获取该锁的代码
 * 在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也即是说，线程可以进入任何一个它拥有的锁所同步着的代码块
 *
 * synchronized是可重入锁
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        Thread t3 = new Thread(phone,"t3");
        Thread t4 = new Thread(phone,"t4");

        t3.start();
        t4.start();

    }
}
