import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/22.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}