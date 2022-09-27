package designmodel.singleton.no;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试用反射破坏单例模式
 * @author yang
 * @date 2022/8/7 12:58
 */
public class NoSingleton02 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //获取singleton的字节码对象
        Class clazz = Singleton07.class;
//        获取无参构造方法对象
        Constructor cons = clazz.getDeclaredConstructor();
        //取消访问检查
        cons.setAccessible(true);
//        创建singleton对象
        Singleton07 s1 = (Singleton07) cons.newInstance();
        Singleton07 s2 = (Singleton07) cons.newInstance();

        System.out.println(s1 == s2);
    }
}
