package RenRen;

/**
 * Created by 殷鑫 on 2017/4/9.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int num[] = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 1; i < n; i++) {
                int temp = i;
                int left = 0;
                int right = 0;
                for (int j = 0; j < i; j++){
                    left += num[j];
                }
                for (int j = i; j < n; j++) {
                    right += num[j];
                }
                if(left == right){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}