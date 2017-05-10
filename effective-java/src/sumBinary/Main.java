package sumBinary;

/**
 * Created by 殷鑫 on 2017/3/23.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;

            a = in.nextInt();

        int[] array = new int[10];
        int i = 0;
        while(a!=0){
          array[i] = a%10;
            a = a/10;
            System.out.println(a);
            i++;
        }
        array[i] = 0;
        int t = i;
        for( i = t-1; i >=0 ; i--){
            int suma = 1;
            int sumb = 1;
            for(int j = 0; j <= i; j++){
                suma = suma * array[j];
            }
            for(int j = t-1; j > i; j-- ){
                sumb = sumb * array[j];
            }
            if(suma == sumb){
                System.out.println("Yes");
                return;
            }
            suma = 1;
            sumb = 1;
        }

        System.out.println("No");
    }
}