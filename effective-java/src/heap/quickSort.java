package heap;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by 殷鑫 on 2017/4/20.
 */
public class quickSort {
    public static void main(String[] args) {
        int[] A = new int[]{12,14,11,23,55,33,44};
        partion(A,0,A.length-1);
        for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + "  ");
        }
    }
    public static void partion(int A[],int start,int end){
        int index = sort(A,start,end);
        if (index < end ){
            sort(A,index+1,end);
        }if (index > start){
            sort(A,start,index-1);
        }
    }

    public static int sort(int A[],int start,int end) {
        int pivot = A[(start + end)/2];
        int index = start;
        int temp = A[end];
        A[end] = pivot;
        A[(start+end)/2] = temp;
        while (start < end){
            if (A[start] < pivot){
                temp = A[start];
                A[start] = A[index];
                A[index] = temp;
                index++;
                start++;
            }
            else {
                start++;
            }
        }
        //交换
        temp = A[index];
        A[index] = A[end];
        A[end] = temp;
        return index;
    }
}
