package sumBinary;

import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by 殷鑫 on 2017/3/23.
 */
public class test4 {
    public test4(){
        System.out.println(this);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] X = new int[count];
        int[] Y = new int[count];
        for (int i = 0; i < count; i++)
            X[i] = scanner.nextInt();
        for (int j = 0; j < count; j++){
            Y[j] = scanner.nextInt();
        }

        int gx = scanner.nextInt();
        int gy = scanner.nextInt();
        int walkTime = scanner.nextInt();
        int taxiTime = scanner.nextInt();
        int minTime = (Math.abs(gx) + Math.abs(gy)) * walkTime;

        int tempTime = 0;
        for (int i = 0;i < count; i++){
            tempTime = (Math.abs(gx-X[i]) + Math.abs(gy - Y[i])) * taxiTime +
                    (Math.abs(X[i]) + Math.abs(Y[i])) * walkTime ;
            if (tempTime <= minTime){
                minTime = tempTime;
            }
        }
        System.out.println(minTime);
    }
}
