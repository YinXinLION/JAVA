package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-14.
 */
public class test11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            s[i] = in.nextInt()/1024;
            sum += s[i];
        }
        int[] dp = new int[sum/2+1];
        for (int i = 0;i < n;i++){
            for (int j = sum/2;j >= s[i];j--){
                //前面的s[i]指的是第i个任务的重量（本题重量就是时长）
                // ，后面的s[i]指的是价值（本题价值也是时长）。
                dp[j] = Math.max(dp[j],dp[j-s[i]]+s[i]);
                //dp[j]当前的重量,或者增加后
            }
        }
        System.out.println(Math.max(dp[sum/2],sum-dp[sum/2])*1024);
    }
}
