package yang;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class myData {
    volatile int number = 0;
    public void addTo60() {
        this.number = 60;
    }

    //此时number前面加了volatile关键字修饰，volatile不保证原子性
    public void addPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}


/**
 * 1、验证volatile的可见性
 *  1.1 假如 int number =0； number变量之前根本没有添加volatile关键字修饰，没有可见性
 *  1.2 添加了volatile，可以解决可见性问题
 *
 * 2、验证volatile不保证原子性
 *  2.1 原子性指的什么意思？
 *      不可分割，完整性，某个线程做某个业务，中间不可分割，
 *      需要整体完整，要面同时成功，要吗同时失败
 *  2.3 why
 *  2.4 如何解决原子性
 *      * 加sync
 *      * 使用我们的juc下AtomicInteger
 *
 * @author yang
 * @date 2022/7/24 13:03
 */
public class VolatileDemo {

    public static void main(String[] args) {
        myData myData = new myData();

        for (int i = 1; i <= 20; i++) {

            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程全部计算完成后，再用main线程取得最终的结果值看是多少
        while (Thread.activeCount() >2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t finally number value"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger finally number value"+myData.atomicInteger);
    }

    ////验证了volatile可以保证可见性，及时通知其它线程，主物理内存的值已经被修改
    public static void seeOkVolatile(String[] args) { //一切方法的运行入口
        myData data = new myData();  //资源类


        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t com in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            data.addTo60();

            System.out.println(Thread.currentThread().getName()+"\t update number value: "+data.number);

        },"AAA").start();
        while (data.number == 0){
            //mian线程就一直在这里等待循环，直到number值不再等于零
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");



    }
}
