package 搜狐畅游;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-17.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fun(n));
    }
    static int fun(int n){
        if(n <= 3){
            return 1;
        }
        return fun(n-1)+fun(n-3);
    }

}
