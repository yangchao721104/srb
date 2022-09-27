package designmodel.singleton;

/**
 * 饿汉式（静态变量）
 * @author yang
 * @date 2022/8/6 23:58
 */

class Singleton2{
    //1.构造器私有华，外部new
    private Singleton2(){}

    //2.本类内部创建对象实例
    private  static Singleton2 instance;

    static {
        instance =new Singleton2();
    }

    //3.提供一个公有的静态方法，返回实例对象
    public static Singleton2 getInstance(){
        return instance;
    }
}

public class Singleton02 {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode()+"------"+ instance2.hashCode());
    }
}
