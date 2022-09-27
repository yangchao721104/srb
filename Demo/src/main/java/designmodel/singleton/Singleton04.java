package designmodel.singleton;

/**
 * 解决线程问题，效率太低
 * @author yang
 * @date 2022/8/7 0:11
 */
class Singleton4{
    private static Singleton4 instance;

    private Singleton4(){}

    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}

public class Singleton04 {
    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode()+"------"+ instance2.hashCode());
    }
}
