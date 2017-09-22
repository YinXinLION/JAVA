package 小米;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yinxin on 17-9-18.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        str = str.toUpperCase();
        char[] s = str.toCharArray();
        List<Character> list = new ArrayList<>();
        list.add('_');
        int Big = 0;
        int Small = 0;
        int number = 0;
        for (int i = 0; i < s.length; i++){
            if (s[i] == '.'){
                list.add('_');
                continue;
            }
            if (Big == 0 || Small == 0 || number== 0){
                if (s[i] >= 'A' && s[i] <='Z'){
                    Big = 1;
                    list.add(s[i]);
                }else if (s[i] >= 'a' && s[i] <='z'){
                    Small = 1;
                    list.add(s[i]);
                }else if (s[i] >= '0' && s[i] <= '0'){
                    System.out.println();
                    number = 1;
                    list.add(s[i]);
                }
                continue;
            }
            if (Big == 1 || Small == 1){
                if (s[i] >= 'a' && s[i]<='z'){
                    list.add(s[i]);
                }
                else {
                    System.out.println("~~");
                    Big = 0;
                    Small = 0;
                    list.add('_');
                    list.add(s[i]);
                    list.add('_');
                }
            }
            if (number == 1){
                if (s[i] >= '0' && s[i] <= '9'){
                    list.add(s[0]);
                }else {
                    number = 0;
                    list.add('_');
                }
            }
        }
        list.add('_');

        for (Character c : list){
            System.out.print(c);
        }
    }
}
