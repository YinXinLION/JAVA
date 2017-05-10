package sumBinary;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/3/25.
 */
public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        char[] child = word.toCharArray();
        int bCount = 0;
        int gCount = 0;
        for (int i = 0; i < child.length; i++) {
            if (child[i] == 'G') {
                gCount++;
            }
            if (child[i] == 'B') {
                bCount++;
            }
        }
        int indexbegin = 0;
        int indexlast = child.length - 1;
        int start = 0;
        int end = 0;
        int Count = 0;
        if (bCount < gCount) {
            for (int i = 0; i < child.length; i++) {
                if (child[i] == 'G') {
                    indexbegin = i;
                    break;
                }
            }
            for (int i = (child.length - 1); i > 0; i--) {
                if (child[i] == 'G') {
                    indexlast = i;
                    break;
                }
            }
            for (int i = 0; i < child.length; i++) {
                if (child[i] == 'B') {
                    start = i;
                    break;
                }
            }
            for (int i = (child.length - 1); i > 0; i--) {
                if (child[i] == 'B') {
                    end = i;
                    break;
                }
            }
            if (start ==0 && indexlast == 0){

                    System.out.println(0);
                    return;
            }
            if ((start - indexbegin) > (indexlast - end))
                for (int i = child.length - 1; i > 0; i--) {
                    if (child[i] == 'B') {
                        Count += indexlast - i;
                        for (int j = i; j < indexlast; j++) {
                            child[j] = child[j + 1];

                        }
                        child[indexlast] = 'B';
                        indexlast--;
                    }
                }
            if ((start - indexbegin) < (indexlast - end)) {
                for (int i = 0; i < child.length; i++) {
                    if (child[i] == 'B') {
                        Count += i - indexbegin;
                        for (int j = i; j > indexbegin; j--) {
                            child[j - 1] = child[j];
                        }
                        child[indexbegin] = 'B';
                        indexbegin++;
                    }
                }

            }
            System.out.println(Count);
            return;
        }
        if (bCount > gCount) {
            for (int i = 0; i < child.length; i++) {
                if (child[i] == 'B') {
                    indexbegin = i;
                    break;
                }
            }
            for (int i = (child.length - 1); i > 0; i--) {
                if (child[i] == 'B') {
                    indexlast = i;
                    break;
                }
            }
            for (int i = 0; i < child.length; i++) {
                if (child[i] == 'G') {
                    start = i;
                    break;
                }
            }
            for (int i = (child.length - 1); i > 0; i--) {
                if (child[i] == 'G') {
                    end = i;
                    break;
                }
            }
            if ((start - indexbegin) >= (indexlast - end))
                for (int i = child.length - 1; i > 0; i--) {
                    if (child[i] == 'G') {
                        Count += indexlast - i;
                        for (int j = i; j < indexlast; j++) {
                            child[j] = child[j + 1];

                        }
                        child[indexlast] = 'G';
                        indexlast--;
                    }
                }
            if ((start - indexbegin) < (indexlast - end)) {
                for (int i = 0; i < child.length; i++) {
                    if (child[i] == 'G') {
                        Count += i - indexbegin;
                        for (int j = i; j > indexbegin; j--) {
                            child[j - 1] = child[j];
                        }
                        child[indexbegin] = 'G';
                        indexbegin++;
                    }
                }
                System.out.println(Count);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}
