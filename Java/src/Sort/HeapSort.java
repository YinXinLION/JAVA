package Sort;

/**
 * Created by yinxin on 17-7-17.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] A = {1,5,3,4,6,8,13,12};
        HeapSort a = new HeapSort();
        int[] B = a.heapSort(A,A.length);
        for (int i : B){
            System.out.print(i + "  ");
        }
    }

    public int[] heapSort(int[] A,int n){
        A = buildMaxHeap(A,n);
        int temp;
        for (int i = n-1; i > 0; i--){
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            adjustDownToUp(A,0,i);
        }
        return A;
    }

    public int[] buildMaxHeap(int[] A,int n){
        //从最后一个节点n的父节点 n/2 开始，直到根节点0，反复调整堆
        for (int i = n/2;i>=0;i--){
            adjustDownToUp(A,i,n); //n个节点
        }
        return A;
    }

    public void adjustDownToUp(int[] A,int k, int n){
        int temp = A[k];
        //左右孩子
        //由于是从0 -> n-1的所以 k的左右孩子为 2*k+1 2*k+2
        for (int i = 2*k+1; i<n; i=2*i+1){
            if (i<n-1&&A[i]<A[i+1]){     //找最大的 如果它不是最后一个 并且小于它兄弟
                i++;
            }
            if (temp >= A[i]){
                //如果父节点大于或等于左右孩子的那个最大的
                break;
            }
            //否则
            A[k] = A[i];
            k = i;
        }
        A[k] = temp;
    }
}
