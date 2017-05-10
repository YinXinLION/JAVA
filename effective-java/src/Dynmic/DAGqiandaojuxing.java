package Dynmic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/25.
 */
public class DAGqiandaojuxing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] G = new int[n][n]; //DAG图的矩阵表示
        int[] d = new int[n];//d[i]定点i的最长路径
        int[][] rectangles = new int[n][2];
        int c = 0;
        while (c < n){
            int max = scanner.nextInt();
            int min = scanner.nextInt();
            if (max > min){
                rectangles[c][0]= min;
                        rectangles[c++][1] = max;
            }else {
                rectangles[c][0]= max;
                rectangles[c++][1] = min;
            }
        }
        createGraph(rectangles,G,n);

        int ans=0;
        for(int i=0;i<n;i++){
            int tmp = dp(i,d,n,G);
            ans=ans>tmp?ans:tmp;
        }
        System.out.printf("%d\n",ans);

    }
    //打印出图的邻接矩阵，目的是确保建图正确无误
    public static void print_Graph(int[][] rec,int[][] G,int n){
        System.out.print("|矩 形|");
        for(int i=0;i<n;i++)
            System.out.printf("%2d,%2d|",rec[i][0],rec[i][1]);
        System.out.println();

        for(int i=0;i<n;i++){
            for(int k=0;k<=n;k++)
                System.out.print("------");
            System.out.println();
            System.out.printf("|%2d,%2d|",rec[i][0],rec[i][1]);
            for(int j=0;j<n;j++){
                System.out.printf("  %d  |",G[i][j]);
            }
            System.out.println();
        }
    }

    //构造图
    public static void createGraph(int[][] rec, int[][] G, int n)
    {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(rec[i][0]>rec[j][0] && rec[i][1]>rec[j][1]){
                    G[i][j]=1; 	//rec[i] 包含 rec[j]
                }
            }
        }
        print_Graph(rec,G,n);
    }

    public static int dp(int i,int[] d,int n,int[][] G){
        if (d[i] > 0) return d[i];
        d[i] = 1;
        for (int j = 0; j < n; j++){
            if (G[i][j] > 0) { //如果可以包起来
                int tmp = dp(j,d,n,G); //获取包起来的d[j]  递归获得
                d[i] = d[i] > tmp+1?d[i]:tmp+1;  //判断 是 d[j]包起来的大，还是 d[i]一开始的大
            }
        }
        return d[i];
    }
}
