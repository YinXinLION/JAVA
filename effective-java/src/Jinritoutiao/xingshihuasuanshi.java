package Jinritoutiao;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/18.
 */
public class xingshihuasuanshi {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String s = scanner.next();
        char[] array1 = s.toCharArray();
        char[] array2 = new char[10000];
        int num1 = 0;
        int num2 = 0;
        int t = 1;
        char x = '0';int flag = 0;
        for (int i = array1.length - 1; i >= 0; i--){
            if (array1[i] != '+' && array1[i] != '-'&&array1[i] != '*'&&array1[i] != '/'){
                if (flag == 0)
                {
                    num1 += (array1[i] - '0')*t;
                    t = t*10;
                }
                if (flag == 1){
                    num2 += (array1[i] - '0')*t;
                    t = t*10;
                }
            }

            if (array1[i] == '+' || array1[i] == '-'||array1[i]== '*'||array1[i] == '/'){
                x = array1[i];
                flag = 1;
                t = 1;
            }
        }
        if (x == '+'){
            array2 = Double.valueOf(num2+num1).toString().toCharArray();
        }if (x == '-'){
            array2 = Double.valueOf(num2 - num1).toString().toCharArray();
        }if (x == '*'){
            array2 = Double.valueOf(num2 * num1).toString().toCharArray();
        }if (x == '/'){
            array2 = Double.valueOf(num2 / num1).toString().toCharArray();
        }
        System.out.println(array2[1]);
        int length = 0;
        for (int i = 0; i < array2.length; i++ ){
            if (array2[i] == '.'){
                length = i - 1;
                break;
            }
        }
        for (int i = 0; i < 5 ; i++){
            for (int j = 0; j < (array1.length+length); j++){


            }
        }
    }
}
