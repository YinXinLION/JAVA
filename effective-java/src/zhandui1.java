import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/7.
 */
public class zhandui1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String word = scanner.next();
        char[] text = word.toCharArray();

        int[] t = new int[num];
        if (num>100000 || num < 1){
            return;
        }
        if (num != text.length){
            return;
        }
        for (int i = 0 ; i < num; i++){
            t[i] = 0;
        }
        for (int i = 0; i < text.length; i++){
            if (text[i] != 'X' && text[i] != '#'){
                int x = Character.getNumericValue(text[i]);

                for (int j = 1; j<=x; j++){
                    if ((i-j) <0){
                        break;
                    }
                    if (text[i - j] == 'X'){
                        t[i-j] = 1;
                    }
                }
                for (int j = 1; j <= x; j++){
                    if ((i+j) > (num-1)){
                        break;
                    }
                    if (text[i+j] =='X'){
                        t[i+j] = 1;
                    }
                }
            }
        }
        int sum = 0;

        for (int i = 0; i <num; i++){
            if (t[i] == 1){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
