package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-14.
 */
public class test12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] s = str.toCharArray();
        int bCount=0,gCount=0;
        int b = 0,g = 0;
        for (int i = 0; i < s.length;i++){
            if (s[i] == 'B'){
                bCount+=(i-b);
                b++;
            }else {
                gCount+=(i-g);
                g++;
            }
        }
        System.out.println(Math.min(bCount,gCount));
    }
}
