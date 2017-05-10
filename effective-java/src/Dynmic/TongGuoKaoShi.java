package Dynmic;

import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/23.
 */
//通过考试
public class TongGuoKaoShi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double[] p = new double[num];
        int t = 0;
        while (t < num){
            p[t] = scanner.nextDouble() / 100;
            t++;
        }
        chakan(p,num);

    }
    public static void chakan(double[] p, int num){
        double[][] dp = new double[num+1][num+1];
        dp[0][0] = 1;
        //行是通过题的数量，列是题的个数
        for (int i = 1; i <= num; i++){
            //初始化第一列，dp[0][0]是0道题作对0道的情况，dp[1][0]是1道题作对0道的情况
            //对于前面i-1道题，作对0道题，同时第i道做错，
            // 概率为 dp[0][0] * (1 - p[0]) <==> dp[i-1][j] * (1-p[i-1])
            // (也就是前面i-1道通过j道题的概率 * 第i道没通过的概率)
            dp[i][0] = dp[i-1][0] * (1 - p[i-1]);
            for (int j = 1; j <= num; j++){ //通过i道的答题情况
                //dp[i-1][j-1] * p[i-1] 前i-1道作对j-1道的概率 * 当前i这个题的概率
                dp[i][j] = dp[i-1][j-1] * p[i-1] + dp[i-1][j]*(1-p[i-1]);
            }
        }
        double pass = 0.0d;
        int i = (int) Math.ceil(num*0.6);//需要做对的题目数
        for ( ; i <= num; i++){
            pass += dp[num][i];//最后一行，大于要答对题目的概率的总和
        }
        System.out.println(pass);
    }
}
