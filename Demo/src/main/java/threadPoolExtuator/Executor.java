package threadPoolExtuator;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * @author yang
 * @date 2022/8/1 9:26
 */
public class Executor {
    @Autowired
    ThreadPoolExecutor executor;
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                5,
                100L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <= 6; i++) {
                final  int tmep = i;
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t ");
                });
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }
}
