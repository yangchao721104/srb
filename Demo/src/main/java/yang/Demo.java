package yang;

import java.util.Scanner;

/**
 * @author yang
 * @date 2022/8/7 18:27
 */
public class Demo {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        new String();


        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder res = new StringBuilder(input);
        System.out.println(res.reverse());
        System.out.println("我爱中国");
    }

}
