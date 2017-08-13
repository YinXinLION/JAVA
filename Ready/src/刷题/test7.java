package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-13.
 */
public class test7 {
    public static long fac(int nNum)
    {
        if(nNum<0)
            return 0;
        if(nNum==0 || nNum==1)
            return 1;
        return nNum*fac(nNum-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long sum = fac(num);
        int rel = 0;
        System.out.println(sum);
        while( sum%10 == 0)        //盘算阶乘末尾0的个数
        {
            rel++;
            sum /= 10;
        }
        System.out.println(rel);
    }
}
