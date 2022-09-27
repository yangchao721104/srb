package javaee.digui;

import junit.framework.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * 实现：fn：求n步台阶，一共有几种走法
 * @author yang
 * @date 2022/8/3 16:43
 */
public class TestStep {

    @Test
    public void test(){
        Instant now = Instant.now();
        System.out.println(f(40));
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        long seconds = between.toMillis();
        System.out.println(seconds);
    }

    public int f(int n) {
        if (n<1){
            Assert.assertNull("n不能小于1",n);
        }
        if (n ==1 || n==2){
            return n;
        }
        return f(n-2) + f(n-1);
    }
}
