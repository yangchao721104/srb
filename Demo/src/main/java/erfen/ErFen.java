package erfen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 二分
 * @author yang
 * @date 2022/8/9 20:39
 */
public class ErFen {
    public static void main(String[] args) {
        int [] array = {1,5,8,10,14,55,67,89};
        int target = 67;
        int idx = erfen(array,target);
        System.out.println(idx);
//        Arrays.binarySe arch();
        ArrayList<Object> list = new ArrayList<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put("1",1);
        new HashMap<>();
    }

    private static int erfen(int[] array, int t) {
        int l = 0,r = array.length-1,m;
        while (l<=r){
            m =(l+r)/2;
            if (array[m] == t){
                return m;
            }else if(array[m] >t){
                r = m-1;
            }else {
                l = m+1;
            }
        }
        return -1;
    }
}
