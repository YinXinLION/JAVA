package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-12.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fun(num));

    }

    public static int fun(int n){
        int count = 0;
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }else {
            for (int i = 1; i < n;i++){
                count += fun(n-i);
            }
            count = count+1;
        }
        return count;
    }
}
