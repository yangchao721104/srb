package dealLock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author yang
 * @date 2022/8/14 22:02
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(",");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        String[][] s = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] s1 = scanner.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                s[i][j] = s1[j];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j].equals("M")){
                    getResult(s,i,j,list);
                }
            }

        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }

    private static void getResult(String[][] s, int i, int j, List<Integer> list) {
        int len = 1;
        int a = 0;
        int b = 0;
        int m = s.length,n = s[0].length;
        if (j<n){
            a = i;
            b=j;
            while (b<n-1 && s[a][++b].equals("M")){
                len++;
            }
            list.add(len);
            len =1;
        }

        if (i<m){
            a = i;
            b=j;
            while (a<m-1 && s[++a][b].equals("M")){
                len++;
            }
            list.add(len);
            len =1;
        }

        if (i<m && j<n){
            a = i;
            b=j;
            while ((a<m-1 && b<n-1) && (s[++a][++b].equals("M"))){
                len++;
            }
            list.add(len);
            len =1;
        }

        if (i<=0 && j<n){
            a = i;
            b=j;
            while ((a>0 && b<n-1) && s[--a][++b].equals("M")){
                len++;
            }
            list.add(len);
        }
    }
}

//        int n = Integer.parseInt(a1[0]);
//        int e = Integer.parseInt(a1[1]);
//        int x =0;
//        int y =0;
//        int a = 0;
//        for (int i = 0; i < n; i++) {
//            String[] a2 = scanner.nextLine().split(" ");
//            int x1 = Integer.parseInt(a2[0]);
//            int y1 = Integer.parseInt(a2[1]);
//            a+=(x1-x)*Math.abs(y);
//            x = x1;
//            y+= y1;
//        }
//        if (x<e){
//            a+=(e-x)*Math.abs(y);
//        }
//        System.out.println(a);
//        scanner.close();










//        long result = 0;
//        int last1 = 0;
//        int last2 = 0;
//        for (int i = 0; i < count; i++) {
//            String[] a2 = scanner.nextLine().split(" ");
//            int x = Integer.parseInt(a2[0]);
//            int y = Integer.parseInt(a2[1]);
//            result = result + (x - last1) * Math.abs(last2);
//            last1 = x;
//            last2 = y;
//        }
//        result = result + (total - last1) * Math.abs(last2);
//        System.out.println(result);
