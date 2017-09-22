package 京东;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-8.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] s = str.toCharArray();

        int count = 0;
        int right = 0;
        int sum = 1;
        for (int i = 0; i < s.length;i++){

            if (count == 0){
                right = 0;
            }
            if (s[i] == ')'){
                right++;

                sum = sum * right;
                if (i+1 == s.length){
                    break;
                }
                if (s[i+1] == '(')
                    right--;

            }

            if (s[i] == '('){
                count++;
            }
            if (s[i] == ')'){
                count--;
            }

        }

        System.out.println(sum);

    }

}
