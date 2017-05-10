import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/8.
 */
/*
*进制回文数
   如果一个数字从左边读和从右边读一样，那么这个数字就是一个回文数。例如32123就是一个回文数；17在某种意义上也是一个回文数，因为它的二进制型式——10001——是一个回文数。请你帮忙开发一个程序，判断一个数n在任意进制（2-16）下是否有回文数。
 */
public class jinzhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[1000];
        int index = 0;
        boolean flag = false;
        for (int i = 2; i <= 16; i++){
            int t = num;
            while (t != 0){
                array[index++] = t % i;
                t = t/i;
            }System.out.print(i+"进制：");
            for (int j = 0 ; j < index; j++){

                System.out.print(array[j]);
            }
            flag = isJinzhi(array,index);
            if (flag == true){
                break;
            }
            index = 0;
            System.out.println();
        }

        if (flag == true){
            System.out.println("        OK");
        }else {
            System.out.println("           False");
        }
    }

    public static boolean isJinzhi(int[] array,int index){
        int start,end;
        if (index == 1){
            return false;
        }
        for (start = 0, end = index-1; start < end;start++,end--){
            if (array[start] - array[end] == 0){
                continue;
            }else {
                break;
            }
        }
        if (start >= end) {
            return  true;
        }
        return false;
    }
}
