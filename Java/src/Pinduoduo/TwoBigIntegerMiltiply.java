package Pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yinxin on 17-8-1.
 */
class NumDividEqual {
    public char[] A;
    public char[] B;
    int n;


    public NumDividEqual(char[] input) {
        n = input.length / 2;
        A = new char[n];
        B = new char[n];
        for (int i = 0; i < n; i++) {
            A[i] = input[i];
        }
        for (int i = 0; i < n; i++) {
            B[i] = input[i + n];
        }
    }
}
public class TwoBigIntegerMiltiply {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st1 = scanner.next();
        String st2 = scanner.next();
        char[] a = st1.toCharArray();
        char[] b = st2.toCharArray();
        TwoBigIntegerMiltiply bg = new TwoBigIntegerMiltiply();
        char[] ret = bg.mult(a, b);
        System.out.println(ret);
    }
    public char[] reverse(char[] input) {
        char[] output = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[input.length - 1 - i];
        }
        return output;
    }


    public NumDividEqual partition(char[] input) {
        return new NumDividEqual(input);
    }


    public int calLength(char[] num1, char[] num2) {
        int len = num1.length > num2.length ? num1.length : num2.length;
        if (len == 1)
            return 1;
        len += len & 1;
        return len;
    }


    public static char[] trimPrefix(char[] input) {
        char[] ret = null;
        for (int i = 0; i < input.length; i++) {
            if (ret == null && input[i] == '0')
                continue;
            else {
                if (ret == null) {
                    ret = new char[input.length - i];//出去数字前面多余的0
                }
                ret[i - (input.length - ret.length)] = input[i];
            }
        }
        if (ret == null)
            return new char[] { '0' };
        return ret;
    }


    public static char[] format(char[] input, int n) {//；
        if (input.length >= n) {
            return input;
        }
        char[] ret = new char[n];
        for (int i = 0; i < n - input.length; i++) {
            ret[i] = '0';
        }
        for (int i = 0; i < input.length; i++) {
            ret[n - input.length + i] = input[i];
        }
        return ret;
    }


    public char[] addTail(char[] input, int n) {//
        char[] ret = new char[input.length + n];
        for (int i = 0; i < input.length; i++) {
            ret[i] = input[i];
        }
        for (int i = input.length; i < ret.length; i++) {
            ret[i] = '0';
        }
        return ret;
    }


    public char[] add(char[] num1, char[] num2) {
        int len = num2.length > num1.length ? num2.length : num1.length;
        int carry = 0;//进位标识
        num1 = format(num1, len);
        num2 = format(num2, len);
        char[] ret = new char[len + 1];

        for (int i = len - 1; i >= 0; i--) {
            int tmp = num1[i] + num2[i] - 96;
            tmp += carry;
            if (tmp >= 10) {
                carry = 1;
                tmp = tmp - 10;
            } else {
                carry = 0;
            }
            ret[len - i - 1] = (char) (tmp + 48);
        }
        ret[len] = (char) (carry + 48);//最后一次，最高位的进位
        return trimPrefix(reverse(ret));
    }

    public static char[] sub(char[] num1, char[] num2) {
        int lenMax = num1.length > num2.length ? num1.length : num2.length;
        char[] newNum1 = Arrays.copyOf(format(num1, lenMax), lenMax);//字符串前面补0，使两串长度相同
        char[] newNum2 = Arrays.copyOf(format(num2, lenMax), lenMax);

        for(int i=0;i<lenMax;i++){//when num1-num2<0 return
            if((newNum1[i]=='0' && newNum1[i]=='0') || newNum1[i] == newNum2[i]){//newNum1 is bigger;
                continue;
            }
            else if(newNum1[i] < newNum2[i]){//不滿足參數num1>num2；
                System.out.println("The Parameter in sub(A,B).A MUST Bigger Than B!");
                System.exit(0);
            }
            else break;
        }

        for(int i=lenMax-1;i>=0;i--){
            if(newNum1[i] < newNum2[i]){//result < 0
                newNum1[i] = (char) (newNum1[i] + '0' + 10 - newNum2[i]);
                newNum1[i-1] = (char) (newNum1[i-1] - 1);
            }
            else{
                newNum1[i] = (char) (newNum1[i] + '0' - newNum2[i]);
            }
        }
        return trimPrefix(newNum1);
    }

    public char[] mult(char[] num1, char[] num2) {
        char[] A, B, C, D, AC, BD, AjB, CjD, ACjBD, AjBcCjD,  SUM;
        int N = calLength(num1, num2);//求两数组中较大数组的长度，如果长度为奇数则+1变偶，方便二分成两部分
        num1 = format(num1, N);//数组高位存整数的高位数；数字前面补0，使长度为n；
        num2 = format(num2, N);
        if (num1.length > 1) {
            NumDividEqual nu1 = partition(num1);//将大整数平均分成两部分
            NumDividEqual nu2 = partition(num2);
            A = nu1.A;
            B = nu1.B;
            C = nu2.A;
            D = nu2.B;
            AC = mult(A, C);//分治求大整数乘法
            BD = mult(B, D);
            AjB = add(A,B);
            CjD = add(C,D);
            ACjBD = add(AC,BD);
            AjBcCjD = mult(AjB, CjD);

            char[] tmp1 = addTail(sub(AjBcCjD, ACjBD), N / 2);//尾部补0，相当于移位
            char[] tmp2 = add(addTail(AC, N), BD);
            SUM = add(tmp1, tmp2);
            char[] test = trimPrefix(SUM);//除去结果前面多余的0
            return test;
        } else {
            Integer ret = (num1[0] - 48) * (num2[0] - 48);
            return ret.toString().toCharArray();
        }
    }

}