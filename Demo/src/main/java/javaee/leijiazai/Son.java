package javaee.leijiazai;

/**
 * @author yang
 * @date 2023/3/15 21:57
 *
 * 先初始化父类 5，1
 * 初始化子类 10,6
 *
 * 子类实例化方法
 * 1 super（）（最前）
 * 2 i =test（）
 * 3 子类的非静态代码块
 * 4 子类的无参构造（最后）
 */
public class Son extends Father{
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(6)");
    }

    Son(){
//        super();//写于不写都会调用父类的构造器
        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }

    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
