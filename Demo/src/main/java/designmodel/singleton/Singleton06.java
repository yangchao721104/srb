package designmodel.singleton;

/**
 * @author yang
 * @date 2022/8/7 0:18
 */

class Singleton6{
    private static volatile Singleton6 instance;

    private Singleton6(){}

    public static Singleton6 getInstance(){
        if (instance == null){
            synchronized (Singleton6.class){
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}

public class Singleton06 {
}
