package Chapter1;

/**
 * Created by yinxin on 17-8-13.
 */
//给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
// 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，使得原字符串变成字符串“cdefab”。
// 请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
public class test1 {
    public static void main(String[] args) {
        String str = "abcdef";
        char[] s = str.toCharArray();
        transform(s);
    }
    public static void transform(char[] s){
        reserve(s,0,1);
        reserve(s,2,s.length-1);
        reserve(s,0,s.length-1);
        System.out.println(s);
    }
    public static void reserve(char[] s,int start,int end){
        while (start <= end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

}
