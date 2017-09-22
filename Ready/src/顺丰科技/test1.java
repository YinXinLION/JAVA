package 顺丰科技;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-20.
 */
public class test1{
        static int[] solve(int[] a) {
            int[] b = new int[a.length];
            int sum = a[a.length-1];
            for (int i = 0; i < a.length-1; i++){
                b[i] = a[i] + a[i+1];
            }
            b[a.length-1] = a[a.length-1];
            return b;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        res = solve(_a);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}
