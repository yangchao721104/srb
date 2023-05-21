package Spring20230314;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * @date 2023/3/14 13:54
 */
public class Spring {
    //自增变量
    public static void main(String[] args) {
        int i = 1;
        i = i++;
//        int j = i++;
//        int k = i + ++i *i++;
        System.out.println("i = " + i);
//        System.out.println("j = " + j);
//        System.out.println("k = " + k);

    }
}
