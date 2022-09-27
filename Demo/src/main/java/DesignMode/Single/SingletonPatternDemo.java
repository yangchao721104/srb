package DesignMode.Single;

/**
 * @author yang
 * @date 2022/7/31 11:56
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 singleObject()是不可见的
//        SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject instance = SingleObject.getInstance();

        //显示消息
        instance.showMessage();


    }
}
