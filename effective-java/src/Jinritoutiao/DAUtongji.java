package Jinritoutiao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 殷鑫 on 2017/4/18.
 */
public class DAUtongji {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set set = new HashSet();
        while (true){
            BigInteger num = scanner.nextBigInteger();
            if (num.equals(BigInteger.ZERO))
                break;
            set.add(num);
        }
        System.out.println(set.size());
    }
}
