package Chapter1;

/**
 * Created by yinxin on 17-8-13.
 */
//字符串的全排列
public class test5 {
    public static void main(String[] args) {
        String str = "123";
        char[] s = str.toCharArray();
        CalcAllPermutation(s,0,s.length-1);
    }

    public static void CalcAllPermutation(char[] s,int from,int to){
        if (to <= 1){
            return;
        }
        if (from == to){
            for (int i = 0; i <= to; i++){
                System.out.print(s[i]);
            }
            System.out.println();
        }else {
            for (int j = from; j <= to; j++)
            {
                swap(s[j], s[from]);
                CalcAllPermutation(s, from + 1, to);
                swap(s[j], s[from]);
            }
        }
    }
    public static void swap(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;
    }
}
