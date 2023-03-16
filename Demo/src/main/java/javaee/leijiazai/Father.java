package javaee.leijiazai;

/**
 * @author yang
 * @date 2023/3/15 21:54
 *   * 父类实例化方法
 *  * 1 super（）（最前）
 *  * 2 i =test（）
 *  * 3 父类的非静态代码块
 *  * 4 父类的无参构造（最后）
 */
public class Father {
    private int i =  test();
    private static int j = method();

    static {
        System.out.println("(1)");
    }

    Father(){
        System.out.println("(2)");
    }

    {
        System.out.println("(3)");
    }

    public int test() {
        System.out.println("(4)");
        return 1;
    }

    public static int method() {
        System.out.println("(5)");
        return 1;
    }

}
