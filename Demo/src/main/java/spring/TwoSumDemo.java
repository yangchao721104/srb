package spring;

import java.util.HashMap;
import java.util.concurrent.locks.LockSupport;

/**
 * @author yang
 * @date 2023/5/20 13:29
 * leeCode第一算法题
 * num=[12,7,11,15] , target =9
 * 2+7 = 9
 * 返回[0,1]
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        int[] myIndex = twoSum2(nums,target);

        for (int index : myIndex) {
            System.out.printf(String.valueOf(index));
        }


    }

    //哈希算法
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int partnerNumber = target - nums[i];
            if (hashMap.containsKey(partnerNumber)){
                return new int[]{hashMap.get(partnerNumber),i};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }

    //暴力解法
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                return new int[]{i, j};
            }
        }
        return null;
    }
}
