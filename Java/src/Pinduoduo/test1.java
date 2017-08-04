package Pinduoduo;

import java.util.Scanner;

/**
 * Created by yinxin on 17-8-1.
 */
public class test1 {
    public static int symbol = 1;//结果的最终符号
    public static int minimunPositive;//最小的正数
    public static int maxNegative = 0;//最大的负数
    private static boolean zeroFlag = false;//是否遇到0

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        int c = 0;
        while (c < num){
            arr[c++] = scanner.nextInt();
        }
        int result = calculate(arr);
        System.out.println(result);


    }

    public static int calculate(int[] input) {
        System.out.println("Calculating!");
        minimunPositive = input[0];
        maxNegative = 0;
        for(int i = 0; i < input.length; i++)
        {
            if(input[i] < 0)
            {
                //最大負數初始化
                if(maxNegative == 0)
                {
                    maxNegative = input[i];
                }
                //如果小于0，改变符号
                symbol *= -1;
                //如果小于0，且大于当前的最大负数，则把当前值赋给最大负数
                if(input[i] > maxNegative)
                {
                    maxNegative = input[i];
                }
            }
            if(input[i] == 0)
            {
                zeroFlag = true;
            }

            //如果当前值大于0，且小于最小正数，则将该值赋给最小正数
            if(input[i] > 0)
            {
                if(input[i] < minimunPositive)
                {
                    minimunPositive = input[i];
                }
            }
        }
        //如果結果符號位負數
        if(symbol == -1)
        {
            if(zeroFlag)
            {

            }
            return maxNegative;
        }
        //如果結果符號位正
        if(symbol == 1)
        {
            if(zeroFlag)
                return 0;
            else
            {
                return minimunPositive;
            }
        }

        return 0;
    }
}
