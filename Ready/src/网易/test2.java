package 网易;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yinxin on 17-9-9.
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count  = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++){
            int num = scanner.nextInt();
            int[] array = new int[num];
            int c = 0;
            for (int j = 0;j < num;j++){
                array[j] = scanner.nextInt();

            }
        }
        for (String s : list){
            System.out.println(s);
        }
    }
}
