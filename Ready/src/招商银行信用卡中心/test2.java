package 招商银行信用卡中心;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-13.
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] s = new int[num];
        for (int i = 0; i <s.length;i++){
            s[i] = scanner.nextInt();
        }
        boolean max = win1(s);
        System.out.println(max);
    }
    public static boolean win1(int[] arr){
        if(arr == null || arr.length == 0){
            return true;
        }
        int a = f(arr,0);
        int b = s(arr,0);
        System.out.println(a);
        System.out.println(b);
        return a > b;
    }

    public static int f(int[] arr,int i){
        if (i == (arr.length -1)){
            return arr[i];
        }
        if (i > arr.length-1){
            return 0;
        }
        return Math.max(arr[i]+s(arr,i+2),arr[i]+s(arr,i+3));
    }

    public static int s(int[] arr,int i){
        if (i >= (arr.length-1)){
            return 0;
        }
        return Math.min(f(arr,i+2),f(arr,i+3));
    }
}
