package Sort;

/**
 * Created by yinxin on 17-8-8.
 */
public class QucikSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,11,5,7,8};
        quickSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
    public static void quickSort(int[] a,int start,int end){
        int index = partition(a,start,end);
        if (index < end){
            partition(a,index+1,end);
        }
        if (index > start){
            partition(a,start,index-1);
        }
    }

    public static int partition(int[] a,int start,int end){
        int pivot = a[(start+end)/2];//中间数
        int index = start;//起点
        int temp = a[end];//end值
        a[end]=pivot;//中间数放最后，最后数放中间
        a[(start+end)/2] = temp;
        while (start<end){
            if (a[start]<pivot){
                temp = a[start];
                a[start]=a[index];
                a[index]=temp;
                index++;
                start++;
            }else {
                start++;
            }

        } //交换
        temp = a[index];
        a[index]=a[end];
        a[end]=temp;
        return index;
    }
}
