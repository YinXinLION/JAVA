package LianXi;

/**
 * Created by 殷鑫 on 2017/4/13.
 */
public class quickSort {
    public static void main(String[] args) {
        int[] a = new  int[]{1,2,11,5,7,8};
        quickSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }
    public static void quickSort(int[] a,int start, int end){
        if (start < end){
            int index  = partition(a,start,end);
            if (index - 1 > start){
                quickSort(a,start,index-1);
            }
            if (index + 1 < end){
                quickSort(a,index+1,end);
            }
        }
    }

    public static int partition(int[] a,int start, int end){
        int pivot = (start+end)/2;
        int index = start;
        int temp;
        temp = a[end];
        a[end] = a[pivot];
        a[pivot] = temp;

        while (start < end){
            if (a[start] < a[end]){
                temp = a[index];
                a[index] = a[start];
                a[start] = temp;
                index++;
                start++;
            }
            else {
                start++;
            }
        }
        temp = a[index];
        a[index] = a[end];
        a[end] = temp;
        return index;


    }
}
