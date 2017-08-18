package 刷题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-15.
 */
public class test14 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] s = new String[n];
        for(int i = 0; i < n; i++)
            s[i] = in.next();

        search(s,0,new HashSet());
        System.out.println(count);
    }

    public static void search(String[] s, int n, HashSet set){
        if (n >= s.length){
            count++;
            return;
        }
        String c = s[n];
        for (int i = 0; i < c.length(); i++){
            int work = c.charAt(i) - '0';
            if (!set.contains(work)){
                set.add(work);
                search(s,n+1,set);
                set.remove(work);
            }

        }

    }
}
