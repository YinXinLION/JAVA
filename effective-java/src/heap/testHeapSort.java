package heap;

/**
 * Created by 殷鑫 on 2017/4/20.
 */
public class testHeapSort {
    public static void main(String[] args) {
        int[] A = new int[]{12,14,11,23,55,33,44};
        A = bulidMaxHeap(A,A.length);
        for (int  i = A.length - 1 ; i > 0; i-- ){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            tiaozheng(A,0,i);
        }
        for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + "  ");
        }
    }
    public static int[] bulidMaxHeap(int[] A,int length){
        for (int i = length/2; i >=0; i--){
            tiaozheng(A,i,length);
        }
        return A;
    }

    public static void tiaozheng(int[] A,int k, int length){
        //获取叶子节点父亲
        int temp = A[k];
        for (int i = 2 * k + 1; i < length; i++){
            if (i < length - 1 && A[i] < A[i+1]){
                i++;
            }
            if (temp >= A[i])
                break;
            A[k] = A[i];
            k = i;
        }
        A[k] = temp;
    }
}
