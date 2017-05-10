package Jinritoutiao;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/18.
 */
public class SameArray {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int m = scanner.nextInt();
        int i = 0;
        int[] array1 = new int[m];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        while (i < m){
            array1[i] = scanner.nextInt();
            i++;
        }
        int n = scanner.nextInt();
        int[] array2 = new int[n];
        i = 0;
        while (i < n){
            array2[i] = scanner.nextInt();
            i++;
        }
        for (int j = 0; j < m; j++){
            map.put(array1[j],1);
        }
        for (int j = 0; j < n; j++){
            if (map.get(array2[j]) != null){
                if (map.get(array2[j]).equals(1)){
                    System.out.print(array2[j] + " ");
                }
            }

        }
    }
}
