package sumBinary;

/**
 * Created by 殷鑫 on 2017/3/16.
 */
public class test {
    public static void main(String[] args) {
        char[] a = new char[100];
        int start = 1;
        a[99] = 1;
        a[98] = 1;
        a[97] = 0;
        a[96] = 0;
        a[95] = 0;
        a[94] = 0;
        a[93] = 1;
        a[92] = 1;
        for (int i = a.length - 1; i >= 0 ;i--){
                if (a[i] == 1 && start == 1){
                    a[i] = 0;
                    start = 1;
                    continue;
                }
                if (a[i] == 0 && start == 1){
                    a[i] = 1;
                    start = 0;
                    continue;
                }
                if (start == 0){
                    break;
                }
        }
        for (int i : a){
            System.out.println(i);
        }
    }
}
