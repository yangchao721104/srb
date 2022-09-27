package jvm;

import sun.security.provider.Sun;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @date 2022/8/1 13:35
 * -XX:InitialHeapSize=1070784320 -XX:MaxHeapSize=17132549120
 * -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompres
 * sedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {



//        byte[] bytes = new byte[10 * 1024 * 1024 * 1024];

//        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
//        System.out.println("配置的虚拟机内存:"+ sun.misc.VM.maxDirectMemory()/1024/1024+"m");
//        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机中的内存信息,堆内存大小64分之一
//        long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机试图使用的最大内存量，堆内存大小的4分之一
//        System.out.println("-xms:"+totalMemory/1024/1024+"m");
//        System.out.println("-xmx:"+maxMemory/1024/1024+"m");
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("1",1);
    }
}
