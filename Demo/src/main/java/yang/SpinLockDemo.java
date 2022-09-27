package yang;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yang
 * @date 2022/7/27 23:39
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        
    }

    //
    public static void main(String[] args) {

    }
}
