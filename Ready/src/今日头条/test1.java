package 今日头条;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-22.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++){
            s[i] = scanner.nextInt();
        }

        System.out.println(get(s));
    }
    public static  int get(int[] s ) {
        int n = s.length;                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1<<n;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
        int max = 0;
        int min = 0;
        int flag = 1;
        for(int i=0 ;i<nbit ; i++) {
            int sum = 0;
            for(int j=0; j<n ; j++) {//每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1<<j ;
                if((tmp & i)!=0) {
                    if (flag == 1){
                        min = s[j];
                        flag = 0;
                    }
                     sum += s[j];

                    if (s[j] < min){
                        min = s[j];
                    }
                    System.out.println("sum"+sum+"min"+min);
                    if (max < s[j]*s[j])
                        max = s[j]*s[j];
                    if (max < sum * min)
                        max = sum*min;

                }
            }
            flag = 1;
        }
        return max;
    }
}
