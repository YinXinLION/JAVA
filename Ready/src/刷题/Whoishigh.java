package 刷题;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-12.
 */
public class Whoishigh {
    public static void main(String[] args) {
        int M=0 ,N=0;
        int i;
        int A = 0,B = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
             N = in.nextInt();
             M = in.nextInt();

//          System.out.println (N + " " + M);

            int[] score = new int[N];
            for(i=0; in.hasNext() && i<N; i++){
                    score[i] = in.nextInt();
        //          System.out.println (score[i] + " ");
            }

            String c = null;

            for(i=0; in.hasNext() && i< M; i++){
                c = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c,A,B,score);
            }
        }
    }
    public static void process(String c,int A,int B,int[] score){
        int begin,end;
        begin = Math.min(A,B);
        end = Math.max(A,B);
        int max = 0;
        if (c.equals("Q")){
            for (int i = begin-1; i < end; i++){
                if (score[i]>max){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else {
            score[A-1] = B;
        }
    }
}
