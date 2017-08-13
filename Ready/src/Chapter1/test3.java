package Chapter1;

/**
 * Created by yinxin on 17-8-13.
 */
//字符串转换成整数
public class test3 {
    public static void main(String[] args) {
        String str = "-100";
        char[] s = str.toCharArray();
        System.out.println(strToInt(s));
    }
    public static int strToInt(char[] s){
        if (s == null){//---判断是否是null
            return  0;
        }
        //2.考虑正负号
        //3.非法字符
        //整型溢出
        int i = 0;
        int sign = 1;
        int n = 0;
        if (s[i] == '+' || s[i] == '-'){
            if (s[i] == '-'){
                sign = -1;
            }
            i++;
        }
        //判断是否时数字,才执行循环
        while (i <= s.length-1){
            int c = s[i] - '0';
            //把之前得到的数字乘以10,再加上当前字符表示的数字
            n = n * 10 + c;
            i++;
        }
        return sign >0 ? n:-n;
    }
}
