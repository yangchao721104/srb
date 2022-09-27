package designmodel.singleton;

/**
 * @author yang
 * @date 2022/8/7 0:29
 */
public class Singleton07 {
    private Singleton07(){}

    private static class Singleton070{
        private static Singleton07 instance = new Singleton07();
    }

    public static Singleton07 getInstance(){
        return Singleton070.instance;
    }

    public static void main(String[] args) {
        Singleton07 instance = Singleton07.getInstance();
        Singleton07 instance2 = Singleton07.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode()+"------"+ instance2.hashCode());
    }
}
