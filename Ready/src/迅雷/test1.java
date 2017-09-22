package 迅雷;

import java.util.*;

/**
 * Created by yinxin on 17-9-19.
 */
public class test1 {
    static int count = 0;
    static List<Integer> list1 = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        SumOfkNumber(m,n);
        System.out.println(count);
    }


    static void SumOfkNumber(int sum, int n)
    {
        // 递归出口
        if (n <= 0 || sum <= 0)
            return;

        // 输出找到的结果
        if (sum == n)
        {
            // 反转list
            Collections.reverse(list1);

            count++;
            Collections.reverse(list1);
        }
        list1.add(0,n);
            //典型的01背包问题
        SumOfkNumber(sum - n, n - 1);   //“放”n，前n-1个数“填满”sum-n
        list1.remove(0);
        SumOfkNumber(sum, n - 1);     //不“放”n，n-1个数“填满”sum
    }
}
