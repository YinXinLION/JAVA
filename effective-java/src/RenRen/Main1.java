package RenRen;

import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/9.
 */


public class Main1 {
    public static int maxNum(int n){
        int[] a = new int[1000];
        int sum=0,l=0,left = 0;
        int max = 1;
        for(int i=2;i<=n;i++)
        {
            a[l++]=i;
            sum+=i;
            if(sum>n)
            {
                sum-=i;l--;left=n-sum;
                break;
            }
        }
        for(int i=l-1;left != 0;left--)
        {
            a[i]++;
            i--;
            if(i<0) i=l-1;
        }
        for(int i = 0; i < l - 1; i++){
            max *= a[i];
        }
        max *= a[l - 1];

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res;
        int _k;
        _k = scanner.nextInt();
        res = maxNum(_k);
        System.out.println(res);
    }
}
