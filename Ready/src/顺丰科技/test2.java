package 顺丰科技;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-20.
 */
public class test2 {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int count = 1;
        int n = 0;
        int w = cin.nextInt();
        while (true) {
            int nArr[] = new int[1];

            for (int i = 0; i < count; i++) {
                StringBuilder resultBuilder = new StringBuilder();
                n = nArr[0];
                int length;
                for (int j = 2; ; j++)
                    if (n <= Math.pow(2, j) - 2) {
                        length = j - 1;
                        break;
                    }
                while (length > 0) {
                    length--;
                    if (n > Math.pow(2, length + 1) - 2 + Math.pow(2, length)) {
                        resultBuilder.append(7);
                        n = n - (int) Math.pow(2, length + 1);
                    } else {
                        resultBuilder.append(4);
                        n = n - (int) Math.pow(2, length);
                    }
                }
                if (Integer.parseInt(resultBuilder.toString()) < w){
                    count++;

                }else {
                    break;
                }

            }
            System.out.println(count);
        }

    }
}
