package 招商银行信用卡中心;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-13.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++){
            if (i % a == 0 && i % b == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
