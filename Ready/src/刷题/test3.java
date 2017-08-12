package 刷题;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-12.
 */
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] s = new int[num];



        for (int i = 0; i < num; i++){
            s[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < num; i++){
            int count = s[i];
            for (int j = i+1; j < num; j++){
                if (s[i] <= s[j]){
                    count = count + s[i];
                }else {
                    break;
                }
            }

            for (int j = i -1; j >=0;j--){
                if (s[i] <= s[j]){
                    count = count + s[i];
                }else {
                    break;
                }
            }
            if (count > max){
                max = count;
            }
        }
        System.out.println(max);
    }
}
