package 去哪儿;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by yinxin on 17-9-20.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        String[] s = m.split(" ");
        int k = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(s);
        List list = new ArrayList();
        for (int i = 0; i < k; i++){
            list.add(s[i]);
        }
        List list1 = new ArrayList();
        Arrays.sort(s,Collections.reverseOrder());
        for (int i = 0; i < k; i++){
           list1.add(s[i]);
        }
        sb.reverse();
        for (Object c : list){
            System.out.print(c+" ");
        }
        System.out.println();
        for (Object c : list1){
            System.out.print(c+" ");
        }

    }
}
