package 递归和动态规划;

/**
 * Created by yinxin on 17-8-30.
 */
public class 斐波那契 {
    public int f1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }
}
