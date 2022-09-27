package designmodel.singleton;

/**
 * @author yang
 * @date 2022/8/7 0:14
 */
class Singleton5{
    private static Singleton5 instance;

    private Singleton5(){}

    public static Singleton5 getInstance(){
        if (instance == null){
            synchronized (Singleton5.class){

                instance = new Singleton5();

            }
        }
        return instance;
    }
}


public class Singleton05 {

}
