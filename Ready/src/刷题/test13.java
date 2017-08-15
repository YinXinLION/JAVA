package 刷题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-14.
 */
public class test13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] s = new int[num];
        for (int i = 0; i < num;i++){
            s[i] = in.nextInt();
        }
        HashSet set = new HashSet();
        int index = s.length-1;
        for (int i = s.length-1; i >= 0; i--){
            if (set.contains(s[i]) == true){
                continue;
            }else {
                s[index] = s[i];
                set.add(s[i]);
                index--;
            }
        }
        String t = "";
        for (int i = index+1; i < s.length;i++){
            t = t+s[i]+" ";
        }
        t = t.substring(0,t.length()-1);
        System.out.println(t);
    }
}
