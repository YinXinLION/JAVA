import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by 殷鑫 on 2017/4/7.
 */
public class zhandui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int c = 0;
        int[] point = new int[number];
        if(number >100 || number < 1){
            return;
        }
        while(c < number){
            point[c] = scanner.nextInt();
            if(point[c] >100 || point[c] < 0){
                return;
            }
            c++;
        }
        float sum  = 0;float s = 1;
        float x = 1;
        int count = (int) Math.ceil((double)number*0.6);
        for (int i = count; i <= number; i++){
            for (int j = 0; j < i; j++){
                s *= (i - j);
                x *= (number - j);
            }
            sum+= x / s;
            s = 1;
            x = 1;
        }
        float ww = 1;
        for (int i = 0; i < number;i++){
            ww *= (double)point[i]/100;
        }
        sum = sum * ww;
        sum = (float) (Math.ceil(sum * 10000)/10000);
        System.out.printf("%.5f",sum);
    }
}
