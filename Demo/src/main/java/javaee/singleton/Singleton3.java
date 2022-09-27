package javaee.singleton;

/**
 * @author yang
 * @date 2022/8/3 15:44
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }
}
