package yang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yang
 * @date 2022/7/19 0:31
 */
public class Test01 {

    @Test
    public void test01(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(list.get(0));
        list.remove(list.get(0));
        if (list == null){
            System.out.println("list为空");
        }
        int size = list.size();
        System.out.println(size);
        //对战胜利的用户
//        List<Integer> list2 = new ArrayList<>();
//
//        int i = 1;
//        while (list2.size() >list.size() * 0.1){
//
//            while (list.size()>=2 || list2.size() >list.size() * 0.1){
//                List list1 = getRandomThreeInfoList(list, 2);
////            list1 对战并返回信息胜利的加入list2
//                if (list.size() == 1) {
//                    list2.add(list.get(0));
//                    list.remove(list.get(0));
//                }
//
//            }
//            //将list2的数据更新到db,
//            if (list != null){
//                //将list数据更新到db
//            }
//            list.addAll(list2);
//            list2 = null;
//
//            i = i +1;
//        }

    }

    private List getWinUser(List<Integer> list, List<Integer> list2) {
        List list1 = getRandomThreeInfoList(list, 2);
//            list1 对战并返回信息胜利的加入list2
        if (list.size() == 1) {
            list2.add(list.get(0));
            list.remove(list.get(0));
        }

        return getWinUser(list,list2);
    }

    /**
     * 在list集合中随机取出指定数量的元素
     * @param list 取元素的集合
     * @param count 个数
     * @return
     */
    private static List getRandomThreeInfoList(List list, int count) {
        List olist = new ArrayList<>();

        if (list.size() <= count) {
            return list;
        } else {
            Random random = new Random();
            for (int i = 0 ;i<count;i++){
                int intRandom = random.nextInt(list.size() - 1);
                olist.add(list.get(intRandom));
                list.remove(list.get(intRandom));
            }
            return olist;
        }
    }
}
