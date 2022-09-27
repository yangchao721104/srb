package designmodel.singleton.no;

import java.io.Serializable;

/**
 * @author yang
 * @date 2022/8/7 12:49
 */
public class Singleton07 implements Serializable{
    //防止反射破坏单例模式
//    private static boolean flag = false;
//    private Singleton07(){
//        synchronized (Singleton07.class){
//            if (flag){
//                throw new RuntimeException("不能创建多个对象");
//            }
//            flag = true;
//        }
//    }

    private Singleton07(){}

    private static class Singleton070{
        private static Singleton07 instance = new Singleton07();
    }

    public static Singleton07 getInstance(){
        return Singleton070.instance;
    }

    //解决序列化破坏单例
//    public Object readResolve(){
//        return Singleton070.instance;
//    }

}
