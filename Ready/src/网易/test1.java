package 网易;

import 链表面试题.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yinxin on 17-9-9.
 */
public class test1 {
    public static int N;
    private static boolean[] used;
    private static int[] result;
    public static  int count = 0;
    public static int c = 0;
    public static int flag = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count  = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++){
            int num = scanner.nextInt();
            N = num;
            int[] array = new int[num+1];
            for (int j = 1;j <= num;j++){
                array[j] = scanner.nextInt();
            }

            used = new boolean[num+1];
            result = new int[num];
            make(0,array);
            if (flag > 0){
                list.add("Yes");
            }else {
                list.add("No");

            }
            flag = 0;
        }
        for (String s : list){
            System.out.println(s);
        }
    }


    public static void make(int level,int[] array){
        for (int i = 1; i <= N; i++){
            if (!used[i]){
                used[i] = true;
                result[level] = array[i];
                make(level + 1,array);
                used[i] = false;
            }
        }
        if (level == N-1){
            for (int i = 0; i < N; i++){
                if (i == N-1){
                    break;
                }
                if (result[i]*result[i+1] %4 == 0){
                    c++;
                }else {
                    c = 0;
                    break;
                }
            }
            if (c == 0){
                flag += 0;
            }else {
                flag += 1;
            }
        }
    }
}
