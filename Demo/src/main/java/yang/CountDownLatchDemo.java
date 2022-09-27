package yang;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * @date 2022/7/28 19:02
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++) {
            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                System.out.println(Thread.currentThread().getName()+"\t国被灭");

                countDownLatch.countDown();
//            },String.valueOf(i)).start();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

            countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t----------班长最后关门走人");
    }
}
