package Chapter1;

/**
 * Created by yinxin on 17-8-13.
 */
public class test6 {
    public static void main(String[] args) {
        String str = "12345678";
        char[] s = str.toCharArray();
        sum(s,9);
    }
    //第二种 即给定一个数字，根据hash映射查找另一个数字是否也在数组中，只需用O(1)的时间，前提是经过O(N)时间的预处理，和用O(N)的空间构造hash表。
    //第一种 2指针
    public static  void sum(char[] s,int key){
        int begin = 0;
        int end = s.length-1;
        while (begin<end){
            int cur = s[begin]-'0' + s[end]-'0';
            if (cur == key){
                System.out.println(s[begin] + "  " + s[end]);
                begin++;
                end--;
            }
            else {
                if (cur < key){
                    begin++;
                }else {
                    end--;
                }
            }

        }
    }
}
