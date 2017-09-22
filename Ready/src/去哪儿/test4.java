package 去哪儿;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-20.
 */
public class test4 {
    static long PowerMod(long a, long b, long c)
    {
        long ans = 1;
        a = a % c;
        while(b>0) {
            if(b % 2 == 1)
            ans = (ans * a) % c;
            b = b/2;
            a = (a * a) % c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        long m = scanner.nextInt();
        System.out.println(PowerMod(a,b,m));
    }
}
