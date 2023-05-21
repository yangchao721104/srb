package jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @date 2022/8/1 22:19
 */
public class Hello {
    public static void main(String[] args) throws InterruptedException {
        byte[] bytes = new byte[1024 * 1024 * 1024];
        Thread.sleep(500);
        System.gc();
    }
}
