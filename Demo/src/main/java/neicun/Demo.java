package neicun;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;

/**
 * java对象在内存中的使用情况
 *         <dependency>
 *             <groupId>org.openjdk.jol</groupId>
 *             <artifactId>jol-core</artifactId>
 *             <version>0.10</version>
 *         </dependency>
 * @author yang
 * @date 2023/5/24 21:51
 */
public class Demo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.printf(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o){
            System.out.printf(ClassLayout.parseInstance(o).toPrintable());
        }


    }
}
