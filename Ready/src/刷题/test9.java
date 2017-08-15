package 刷题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-14.
 */
//进制转换
public class test9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();


        System.out.println(new BigInteger(String.valueOf(M)).toString(N).toUpperCase());
    }
}
