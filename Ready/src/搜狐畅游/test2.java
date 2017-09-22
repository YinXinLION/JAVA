package 搜狐畅游;

/**
 * Created by yinxin on 17-9-17.
 */
public class test2 {
    public static void main(String[] args) {
        Integer[] s = new Integer[2];
        int count = 0;
        for (Integer is : s){
            is = count++;
        }
        for (Integer i: s){
            System.out.println(i);
        }
    }
}
