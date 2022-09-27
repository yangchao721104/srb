package yang;

import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Filter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author yang
 * @date 2022/7/25 16:13
 */
public class Test {
    public static void main(String args[]){

        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            map.put(UUID.randomUUID().toString(),12);
            System.out.println(map.toString()+i);
        }

}
//        Java8Tester java8Tester = new Java8Tester();
//        Integer value1 = null;
//        Integer value2 = new Integer(10);
//
//        // Optional.ofNullable - 允许传递为 null 参数
//        Optional<Integer> a = Optional.ofNullable(value1);
//
//        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
//        Optional<Integer> b = Optional.of(value2);
//        System.out.println("a"+a+"b"+b);
//
//    }
//
//    public Integer sum(Optional<Integer> a, Optional<Integer> b){
//
//        // Optional.isPresent - 判断值是否存在
//
//        System.out.println("第一个参数值存在: " + a.isPresent());
//        System.out.println("第二个参数值存在: " + b.isPresent());
//
//        // Optional.orElse - 如果值存在，返回它，否则返回默认值
//        Integer value1 = a.orElse(new Integer(0));
//
//        //Optional.get - 获取值，值需要存在
//        Integer value2 = b.get();
//        return value1 + value2;
//    }

}

