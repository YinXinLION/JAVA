package sumBinary;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/3/23.
 */
public class test3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int i = 0;
        String[] s = new String[a];
        while (i != a){
            s[i] = in.next();
            i++;
        }
        for (i = 0; i < a; i++){
            s[i] = Select.sort(s[i]);
        }
        int count = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int x = 0; x < a; x++){
            if (hashMap.get(s[x]) == null){
                for (int j = x+1; j < a; j++){
                    if (s[x].equals(s[j])){
                        hashMap.put(s[x],1);
                        break;
                    }
                }
                count++;
            }
            else {
                continue;
            }
        }

        System.out.println(count);

    }
}
class Select{
    public static String sort(String str){
        //利用toCharArray可将字符串转换为char型的数组
        char[] s1 = str.toCharArray();
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<i;j++){
                if(s1[i]<s1[j]){
                    char temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }
            }
        }
        //再次将字符数组转换为字符串，也可以直接利用String.valueOf(s1)转换
        String st = new String(s1);
        return st;
    }
}