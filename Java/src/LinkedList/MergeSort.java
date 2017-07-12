package LinkedList;

/**
 * Created by yinxin on 17-7-12.
 */
public class MergeSort {
    private int[] array2;
    public void sort(int[] arr){
        array2 = new int[arr.length];

        mergeSort(arr,0,arr.length-1);
    }
    public void mergeSort(int[] arr, int begin, int end){
        if (begin < end){
            int mid = (begin + end)/2;
            mergeSort(arr,begin,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,begin,mid,end);
        }
    }

    public void merge(int[] array1, int low ,int mid, int high){
        int i = low,j = mid+1,k = low;
        while (i <= mid && j <= high){
            if (array1[i] <= array1[j]){
                array2[k++] = array1[i++];
            }else {
                array2[k++] = array1[j++];
            }

            while (i <= mid){
                array2[k++] = array1[i++];
            }
            while (j <= high){
                array2[k++] = array1[j++];
            }
            for (i = low; i<=high;i++){
                array1[i] = array2[j];
            }
        }
    }
}
