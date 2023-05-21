package jvm.error;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yang
 * @date 2022/8/1 23:04
 */
public class StackOverFlowErrorDemo {


    //java.lang.OutOfMemoryError: unable to create new native thread
//    public static void main(String[] args) {
//        for (int i = 1;  ; i++) {
//            System.out.println("=================== i=" +i);
//
//            new Thread(() -> {
//                try {
//                    Thread.sleep(Integer.MAX_VALUE);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }, "AAA"+i).start();
//        }
//    }

    //java.lang.OutOfMemoryError: Direct buffer memory
    //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
//    public static void main(String[] args) {
//        System.out.println("配置的虚拟机内存:"+ sun.misc.VM.maxDirectMemory()/1024/1024+"m");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
//    }

    //java.lang.OutOfMemoryError: Java heap space
    //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
//    public static void main(String[] args) {
//        int i = 0;
//        List<String> list = new ArrayList<>();
//        try {
//            while (true){
//                list.add(String.valueOf(++i).intern());
//            }
//        } catch (Exception e) {
//            System.out.println("***************"+i);
//            e.printStackTrace();
//            throw e;
//        }
//    }

//    java.lang.OutOfMemoryError 内存溢出
//    public static void main(String[] args) {
//        String str = "yang";
//        while (true){
//            str+= str +new Random().nextInt(111111111)+new Random().nextInt(2222222);
//            str.intern();
//        }
//    }

//    java.lang.StackOverflowError  栈溢出错误
//    public static void main(String[] args) {
//        stackOverFlowError();
//    }
//    private static void stackOverFlowError() {
//        stackOverFlowError();
//    }
}
