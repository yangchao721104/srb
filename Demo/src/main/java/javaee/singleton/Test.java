package javaee.singleton;

/**
 * @author yang
 * @date 2022/8/3 15:42
 */
public class Test {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.INSTANCE;
        System.out.println(instance);
        Singleton2 instance1 = Singleton2.INSTANCE;
        System.out.println(instance1);
    }
}
