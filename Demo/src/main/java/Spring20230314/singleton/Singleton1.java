package Spring20230314.singleton;

import DesignMode.Single.Lazy.Singleton;

/**
 * @author yang
 * @date 2023/3/15 0:12
 *
 * 饿汉式：
 *  直接创建对象，不管你是否需要这个对象
 *
 * 1、构造器私有华
 * 2、自行创建，并且用静态变量保存
 * 3、向外提供这个实例
 * 4、强调这是一个单例，可以用final修改
 */
public class Singleton1 {
    
    //懒汉式

//    public static final Singleton1 INSTANCE = new Singleton1();
//    private Singleton1(){
//    }

    // 懒汉式

    /**
     * 在内部类被加载和初始化时，才创建INSTANCE实例对象
     * 静态内部类不会自动随着外部类的加载和初始化而初始化，他要单独去创建和加载
     * 因为是在内部类加载和初始化时，创建的，因为是线程安全的
     */
    private Singleton1(){

    }
    private static class Inner{
        private static final  Singleton1 INSTANCE = new Singleton1();
    }
    public static Singleton1 getInstance(){
        return Inner.INSTANCE;
    }
}
