package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-14.
 */
public class test10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++){
            s[i] = in.nextInt();
        }
        long[][] dp = new long[n+1][sum+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 0;j <= sum;j++){
                if (j >= s[i-1]){
                                //一种情况是你放了，一种是你没放（则使用当前的s[i]）
                    dp[i][j] = dp[i-1][j-s[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];//只能是之前放的结果
                }
            }
        }
        System.out.println(dp[n][sum]);
    }


}
