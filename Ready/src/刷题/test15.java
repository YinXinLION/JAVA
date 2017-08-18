package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-15.
 */
public class test15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++){
            str[i] = in.next();
        }
        int count = 0;
        for (int j = 0; j < n; j++){
            int c = 1;
            for (int i = 0; i < n-1; i++)
            {
                if (str[i].charAt(j) == str[i+1].charAt(j)){
                    c++;
                    count = Math.max(c,count);
                }else {
                    c = 1;
                }
            }
        }
        System.out.println(count);
    }
}
