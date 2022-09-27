package yang;

/**
 * @author yang
 * @date 2022/7/24 14:44
 */
public class SingletonDemo {
    private static volatile SingletonDemo ins = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo()");
    }


    //加synchronized可解决多线程情况下问题，但是太重，不利于并发
    //DCL (duoble check lock 双端检锁机制)
    public static synchronized SingletonDemo getInstance(){
//        if (ins == null){
//            ins = new SingletonDemo();
//        }

        if (ins == null){
            synchronized (SingletonDemo.class){
                if (ins == null){
                    ins = new SingletonDemo();
                }
            }
        }

        return ins;
    }

    public static void main(String[] args) {
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());


        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }

}
