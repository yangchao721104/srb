package yang.product;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized和
 */


//资源类
class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                //等待，不能生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            //通知唤醒
            condition.signalAll();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }


    //消费者
    public void decrement() throws Exception {
        lock.lock();
        try {
            //判断
            while ( number == 0){
                //等待，不能生产
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t "+number);

            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        }
    }


/**
 * 一个初始值为零的变量，两个线程对其交替操作，一个加1，一个减1
 * 1. 线程  操作  资源类
 * 2  判断  干活   通知
 * 3  防止虚假唤醒
 * @author yang
 * @date 2022/7/31 13:21
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }
}
