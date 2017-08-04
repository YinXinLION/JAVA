package Pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-1.
 */
public class text2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] A = new int[num];
        int c = 0;
        int t;
        while (c < num){
            t = scanner.nextInt();
                if (t < 0){
                    A[c++] =-t;
                }
                else {
                    A[c++]=t;
                }
        }
        Arrays.sort(A);
        int result = 1;
        int count = 0;
        int flag = 0;
        for (int i = num-1; i >=0; i--){
            if (A[i] != 0){
                result *=A[i];
                count++;
            }else {
                flag = 1;
            }
            if (count == 3){
                break;
            }
        }

        if (num == 3 && result == 1 && flag == 1){
            result = 0;
        }
        System.out.println(result);

    }

}
