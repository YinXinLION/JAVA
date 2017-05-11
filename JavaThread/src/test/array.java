package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 殷鑫 on 2017/2/27.
 */
public class array {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,1},
                {1,2,3,4},
                {7,8,9}
        };

        System.out.println(Arrays.deepToString(arr));//打印多维数组元素
    }
}
