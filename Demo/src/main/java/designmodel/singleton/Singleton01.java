package designmodel.singleton;

/**
 * 饿汉式（静态变量）可用，会造成内存浪费（类加载时会直接创建）
 * @author yang
 * @date 2022/8/6 23:51
 */

class Singleton{
    //1.构造器私有华，外部new
    private Singleton(){}

    //2.本类内部创建对象实例
    private final static Singleton instance =new Singleton();

    //3.提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}

public class Singleton01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode()+"------"+ instance2.hashCode());
    }
}
