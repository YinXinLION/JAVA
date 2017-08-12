package 刷题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-12.
 */
public class test2 {
    static int[] money = new int[]{1,5,10,20,50,100};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(count(num));
    }
    public static long count(int n){
        int h = money.length;
        long dp[][] = new long[h][n+1];
        Arrays.fill(dp[0],1);
        for (int i = 1;i < h;i++){
            for (int j = 1; j <= n;j++){
                int m = j / money[i];//表示可以由多少个money[i]组成
                for (int k = 0; k <= m;k++){
                    dp[i][j] +=  dp[i-1][j-k*money[i]];
                }
            }
        }
        return dp[h-1][n];
    }
}
