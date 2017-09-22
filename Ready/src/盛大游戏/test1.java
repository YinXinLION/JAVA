package 盛大游戏;

import java.util.Scanner;

/**
 * Created by yinxin on 17-9-10.
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.next();
        char[] s = arr.toCharArray();
        int sum = 0;
        int flag_number = 0;
        int flag_charA = 0;
        int flag_chara = 0;
        int flag_fuhao = 0;
        if (s.length <=4){
            sum+=5;
        }else if (s.length<=7 && s.length >=5){
            sum+=10;
        }else if (s.length >=8){
            sum+=25;
        }
        for (int i = 0; i < s.length; i++){
            if ( s[i] >= 'A' && s[i] <= 'Z'){
                flag_charA = 1;
            }else if ( s[i] >= 'a' && s[i] <= 'z'){
                flag_chara = 1;
            }else if ( s[i] >= '0' && s[i] <='9'){
                flag_number++;
            }else {
                flag_fuhao++;
            }
        }
        if (flag_chara > 0 && flag_charA > 0){
            sum+=20;
        }else if (flag_charA >0 && flag_chara == 0){

            sum+=10;
        }else if (flag_chara > 0 && flag_charA == 0){

            sum+= 10;
        }

        if (flag_number == 1){
            sum+= 10;
        }else if (flag_number > 1){
//            System.out.println("10");
            sum+=20;
        }

        if ((flag_fuhao) ==1){
            sum+=10;
        }else if (flag_fuhao > 1){
            sum+=25;
        }

        if (flag_number > 0 && (flag_charA > 0) && (flag_fuhao>0) && (flag_chara > 0)){
            sum+= 5;
        }
        else if ((flag_chara+flag_charA) > 0 && flag_number > 0 && flag_fuhao > 0){
            sum+=3;
        }
        else if ((flag_chara+flag_charA) > 0&& flag_number > 0){
            sum+=2;
        }
        if (sum >= 90){
            System.out.println("VERY_SECURE");
        }else if (sum >= 80){
            System.out.println("SECURE");
        }else if (sum >=70){
            System.out.println("VERY_STRONG");
        }else if (sum>=60){
            System.out.println("STRONG");
        }else if (sum>=50){
            System.out.println("AVERAGE");
        }else if (sum>=25){
            System.out.println("WEAK");
        }else {
            System.out.println("VERY_WEAK");
        }
    }
}
