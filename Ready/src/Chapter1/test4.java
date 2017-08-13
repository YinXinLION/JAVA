package Chapter1;

/**
 * Created by yinxin on 17-8-13.
 */
public class test4 {
    public static void main(String[] args) {
        String str = "abba";
        char[] s = str.toCharArray();
        System.out.println(one(s));
    }

    public static boolean one(char[] s){
        int front = 0;
        int back = s.length-1;
        while (front < back){
            if (s[front] != s[back]){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    //第二种 中间向两边

}
