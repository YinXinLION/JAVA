package 刷题;

/**
 * Created by yinxin on 17-8-30.
 */
public class test17 {
    public static void main(String[] args) {
        search(3);
    }
    public static int search(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return search(n-1)+search(n-2);

    }
}
