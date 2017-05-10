import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能*/
/*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    public static int maxProfit(int[] prices, int length) {
        int res = 0;
        int dp[][] = new int[length][length];
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = prices[j] - prices[i];
                System.out.print(dp[i][j] + " ");
            }

        }

        int max = 0;
        int ma2 = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        System.out.println(start + " " + end + " " + max);
        for (int i = 0; i < start; i++)
            for (int j = i + 1; j < start; j++) {
                if (dp[i][j] > ma2) {
                    ma2 = dp[i][j];

                }
            }

        if (end < length - 1)
            for (int i = end + 1; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (dp[i][j] > ma2) {
                        ma2 = dp[i][j];

                    }
                }
            }
        res = max + ma2;
        System.out.println(res + " asdasdasd");
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _stockPrices_size = 0;
        _stockPrices_size = Integer.parseInt(in.nextLine().trim());
        int[] _stockPrices = new int[_stockPrices_size];
        int _stockPrices_item;
        for(int _stockPrices_i = 0; _stockPrices_i < _stockPrices_size; _stockPrices_i++) {
            _stockPrices_item = Integer.parseInt(in.nextLine().trim());
            _stockPrices[_stockPrices_i] = _stockPrices_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());
        System.out.println(_k+"asdasdsdsadasdasd");
        res = maxProfit(_stockPrices, _k);
        System.out.println(String.valueOf(res));


//        ExecutorService cache = new ScheduledThreadPoolExecutor();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        //
    }
}
