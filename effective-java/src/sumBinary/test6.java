package sumBinary;

import java.util.Collections;
import java.util.Scanner;

public class test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int c = 0;
        int[][] array = new int[num][6];
        System.out.println(num);
        while ( c < num){
            int j = 0;
            array[c][j++] = scanner.nextInt();
            array[c][j++] = scanner.nextInt();
            array[c][j++] = scanner.nextInt();
            array[c][j++] = scanner.nextInt();
            array[c][j++] = scanner.nextInt();
            array[c][j] = c;
            c++;
        }

        for(int i = 0; i < num - 1; i++){
            int t = i;
            for(int j = i  ; j < num ; j++ ){
                int num1 = array[t][0]+array[t][1]+array[t][2]+array[t][3]+array[t][4];
                int num2 = array[j][0]+array[j][1]+array[j][2]+array[j][3]+array[j][4];
                if (num1 > num2){
                    t = j;
                }
                int[] temp = new int[6];
                for (int w = 0 ; w < 6; w++){
                    temp[w] = array[i][w];
                }
                for (int w = 0; w < 6; w++){
                    array[i][w] = array[t][w];
                }
                for (int w = 0; w < 6; w++){
                    array[t][w] = temp[w];
                }
            }
        }


        int i  = 0;
        int start = 0;
        while (i < num - 1){
            int num1 = array[i][0]+array[i][1]+array[i][2]+array[i][3]+array[i][4];
            int num2 = array[i+1][0]+array[i+1][1]+array[i+1][2]+array[i+1][3]+array[i+1][4];
            if (num1 == num2){
                i++;
                continue;
            }else {
                sss(array,start,i);
                i++;
            }
            start = i;
        }



        for (int j = num - 1; j >= 0; j--){
            System.out.print(array[j][5] + " ");
        }

    }
    public static void sss(int[][] array, int start,int end){
        for(int i = start; i <= end ; i++){
            int t = i;
            for(int j = i  ; j < end ; j++ ){
                int num1 = array[t][0]+array[t][1]+array[t][2]+array[t][3]+array[t][4];
                num1 = num1 / 5;
                int num2 = array[j][0]+array[t][1]+array[j][2]+array[j][3]+array[j][4];
                num2 = num2 /5;
                if (num1 > num2){
                    t = j;
                }
                int[] temp = new int[6];
                for (int w = 0 ; w < 6; w++){
                    temp[w] = array[i][w];
                }
                for (int w = 0; w < 6; w++){
                    array[i][w] = array[t][w];
                }
                for (int w = 0; w < 6; w++){
                    array[t][w] = temp[w];
                }
            }
        }
    }
}
