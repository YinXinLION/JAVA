package 京东;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-8.
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Long c = sc.nextLong();
        int num = 0;
        for (int i = 1; i <= c;i++){
            for (int j = 1; j <= c;j++){
                int m = (int) Math.pow(i,j);
                for (int x = 1; x <= c; x++){
                    for (int y = 1; y <= c; y++){
                        int n = (int) Math.pow(x,y);
                        if (m == n){
                            num++;
                        }
                    }
                }
            }
        }
        System.out.println(num);
    }
}
