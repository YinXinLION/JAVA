package Dynmic;

import java.util.concurrent.FutureTask;

/**
 * Created by 殷鑫 on 2017/4/22.
 */
//找零钱
public class ZhaoLingQian {
    public static void main(String[] args) {
        int[] penny = new int[]{1,2,3};
        System.out.println(countWays1(penny,3,3));
    }

    public static int countWays1(int[] penny, int n, int aim) {
        if (penny == null || penny.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[penny.length][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for(int i=0;i<aim+1;i++){
            if(i%penny[0]==0)
                dp[0][i]=1;
        }
        //循换货币面值个数 - 1 因为 上面那个for循环已经计算得出
        for (int i = 1; i < penny.length; i++) {
            //从第二行 第2列开始
            for (int j = 1; j <= aim; j++) {
                if(penny[i]>j) //如果货币面值大于总aim
                    dp[i][j]=dp[i-1][j]; //那么就是dp[i][j]上面的那个元素值 == dp[i-1][j]
                else  //如果货币面值大于或者等于aim
                    dp[i][j]=dp[i-1][j]+dp[i][j-penny[i]];//不用货币的 加上 少用1张货币，2张 3张)
            }
        }
        return dp[n-1][aim];
    }

    public static int countWays2(int[] penny, int n, int aim) {
        int[] dp = new int[aim+1];//默认初始化为0
        for(int i = 0;i <= aim;i++)
            if(i % penny[0] == 0)
                dp[i] = 1;

        for(int i = 1;i < n; i++)
            for(int j = 1;j <= aim;j++)
                if(j>=penny[i])
                    dp[j] += dp[j-penny[i]];

        return dp[aim];
    }
}
