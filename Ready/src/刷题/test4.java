package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-12.
 */
public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLength = 0;
        int[][] dp = new int[50+1][50+1];
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i = 1; i <= len1; i++){
            for (int j = 1;j <= len2;j++){
                if (s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if (dp[i][j] >maxLength){
                        maxLength = dp[i][j];
                    }
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(maxLength);
    }
}
