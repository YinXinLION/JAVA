package 去哪儿;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-20.
 */
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        int m = scanner.nextInt();
        long sum = 1;
        for (int i = 1;i <= b; i++){
            sum = sum*a;
        }
        System.out.println(sum%m);
    }
}
