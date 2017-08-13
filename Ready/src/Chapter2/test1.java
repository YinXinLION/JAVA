package Chapter2;

/**
 * Created by yinxin on 17-8-13.
 */
//跳台阶问题
public class test1 {
    public static void main(String[] args) {
        System.out.println(Fo(5));
        System.out.println(Fo1(5));
    }
    //第一种
    public static int Fo(int  num){
        if (num == 0){
            return 0;
        }
        if (num == 1){
            return  1;
        }
        if (num == 2){
            return 2;
        }
        return Fo(num-1)+Fo(num-2);
    }
    //第二种
    public static int Fo1(int num){
        int[] dp = new int[]{1,1,1};
        if (num < 2){
            return 1;
        }
        for (int i = 2; i <= num;i++){
            dp[2]=dp[0]+dp[1];
            dp[0]=dp[1];
            dp[1]=dp[2];
        }
        return dp[2];
    }
}
