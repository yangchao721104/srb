package Spring20230314.mianshi2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile的可见性
 *
 * @author yang
 * @date 2023/3/26 23:22
 */
public class Volatile {
     int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    AtomicInteger atomicInteger =  new AtomicInteger();

    public void setNumber(int number) {
        atomicInteger.getAndIncrement();
    }
    //    public static void main(String[] args) {
//        Volatile aVolatile = new Volatile();
//
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"come in");
//            try {
//                TimeUnit.SECONDS.sleep(3);
//                aVolatile.addTo60();
//                System.out.println(Thread.currentThread().getName()+"update number value:"+aVolatile.number);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        },"AAA").start();
//
//        //第二个线程
//        while (aVolatile.number == 0){
//
//        }
//        System.out.println(Thread.currentThread().getName()+"mission is over");
//    }
}
