package javaee.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

import sun.misc.Version;

/**
 * @author yang
 * @date 2022/8/3 22:24
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        new ReentrantLock();
        String str1 = new StringBuilder("58").append("yang").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        String s = new StringBuilder("ja").append("va").toString();
        System.out.println(s);
        System.out.println(s.intern());
        System.out.println(s == s.intern());
    }
}
