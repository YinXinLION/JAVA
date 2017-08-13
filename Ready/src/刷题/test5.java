package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-12.
 */
public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] s = new int[len];
        for (int i = 0; i < len; i++){
            s[i] = scanner.nextInt();
        }
        int max = s[0];
        int count = 0;
        for (int i = 0; i <len; i++){
            if ((count+s[i]) < 0){
                if (count > max)
                    max = count;
                count=0;
            }else {
                if (count > max){
                    max = count;
                }
                count+=s[i];
            }
        }
        if (count > max){
            max = count;
        }
        System.out.println(max);
    }
}
