package 京东;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-8.
 */
public class test3 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String str = scanner.next();
        char[] s = str.toCharArray();
        int left=1;
        int right=0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='('){
                right+=1;
            }else{
                left*=right;
                right--;
            }
        }
        System.out.println(left);
    }
}
