package Sort;

/**
 * Created by yinxin on 17-8-13.
 */
public class InserSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,5,7,2};
        InsertSort(array);
        for (int i : array){
            System.out.println(i);
        }
    }
    public static void InsertSort(int[] a){
        int j = 0;
        for (int i = 0;i < a.length; i++){
            int temp = a[i];
            for (j =  i-1; j>=0; j--){
                if (temp< a[j]){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = temp;
        }
    }
}
