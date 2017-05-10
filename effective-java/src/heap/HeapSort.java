package heap;

/**
 * Created by 殷鑫 on 2017/4/6.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] A = new int[]{10,3,5,13,18,20,44,33,66};
        A =bulidMaxHeap(A,A.length);
        int temp;
        for (int i = A.length-1; i > 0; i-- ){
            //调整好大根堆然后放后面长度-1
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            adjustDownToUp(A,0,i);
        }
        for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + "  ");
        }
    }

    public static int[] bulidMaxHeap(int[] A, int n){
        for (int i = n/2; i >= 0; i--){ //从最后一个节点（n-1）的父节点（n-1-1）/2开始，到节点0结束，反复调整
            adjustDownToUp(A,i,n);
        }
        return A;
    }
    //将元素自下往上逐步调整为堆结构
    public static void adjustDownToUp(int[] A, int k, int n){
        int temp = A[k]; //保留父节点的值给temp，防止叶子节点大于父节点进行交换
        for (int i = 2*k + 1; i < n; i = 2*i + 1){
            if (i < n-1 && A[i] < A[i+1]){
                i++; //取较大的节点
            }
            if (temp >= A[i]){ //如果叶子节点都是小的
                break;
            }
            //如果叶子节点有大于父节点
            A[k] = A[i];
            k = i;
        }
        A[k] = temp;
    }
}
