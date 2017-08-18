package 刷题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-15.
 */
//小易参与了一个记单词的小游戏。游戏开始系统提供了m个不同的单词，
// 小易记忆一段时间之后需要在纸上写出他记住的单词。
// 小易一共写出了n个他能记住的单词，如果小易写出的单词是在系统提供的，
// 将获得这个单词长度的平方的分数。注意小易写出的单词可能重复，但是对于每个正确的单词只能计分一次。
public class test16 {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] N = new String[n];
        String[] M = new String[m];
        for (int i = 0; i < n; i++){
            N[i] = in.next();
        }
        for (int i = 0; i < m; i++){
            M[i] = in.next();
        }
        HashSet set = new HashSet();
        for (int i = 0; i < N.length; i++){
            set.add(N[i]);
        }
        HashMap set1 = new HashMap();
        for (int i = 0; i < M.length; i++){
            if (set.contains(M[i])){
                set1.put(M[i],1);
            }
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t.start();
        t.sleep(20);
        int count = 0;
        for (Object key : set1.keySet()){
            String s = (String)key;
            int i = s.length();
            count+= i*i;
        }
        System.out.println(count);
    }
}
