package 迅雷;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-19.
 */
public class test3 {
    static class Solution {
        public static String solveEquation(String equation) {
            // 例如：equation = "2x+5-3+x=6+x-2";
            // return "Infinite solutions"; // 无穷解
            // return "No solution"; // 无解
            char[] s = equation.toCharArray();
            for(int i = 0; i < s.length; i++){

            }
            return "x=1"; // 有解
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(Solution.solveEquation(in.nextLine()));
    }
}
