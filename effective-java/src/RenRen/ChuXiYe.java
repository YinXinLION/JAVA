package RenRen;

import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/9.
 */
public class ChuXiYe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int time = 60*4;
        time = time - m;
        int timez = 0;
        int count = 0;
        if (time == 0){
            System.out.println("0");
            return;
        }
        for (int i = 1; i <= n; i++){
            count = i;
            time = time - i * 5;
            if (time <= 0){
                break;
            }
        }
       if (time >= 0){
           System.out.println(count);
       }
        if ( time < 0){
            System.out.println(--count);
        }

    }
}






