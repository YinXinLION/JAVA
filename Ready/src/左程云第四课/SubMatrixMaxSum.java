package 左程云第四课;

/**
 * Created by yinxin on 17-9-9.
 */
public class SubMatrixMaxSum {
    public static int maxSum(int[][] m){
        if (m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;//累加数组
        /*
        1              2       3     4
        12             23      34
        123            234
        1234
        在这些中都找出来最大的
         */
        for (int i = 0; i != m.length; i++){
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++){
                cur = 0;
                for (int k = 0; k < s.length;k++){
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max,cur); //最大值和cur的比较
                    cur = cur < 0 ? 0:cur;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
