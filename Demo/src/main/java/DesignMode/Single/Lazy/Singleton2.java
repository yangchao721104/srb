package DesignMode.Single.Lazy;

/**
 * 懒汉式，线程安全
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 * @author yang
 * @date 2022/7/31 12:03
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
