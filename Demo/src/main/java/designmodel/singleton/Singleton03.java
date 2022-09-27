package designmodel.singleton;

/**
 * 懒汉式
 * @author yang
 * @date 2022/8/7 0:06
 */

class Singleton3{
    private static Singleton3 instance;

    private Singleton3(){}
    //提供一个静态的公有方法，当时用到该方法时，采取创建instance
    public static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}

public class Singleton03 {
    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode()+"------"+ instance2.hashCode());
    }
}
