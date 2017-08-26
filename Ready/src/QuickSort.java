/**
 * Created by yinxin on 17-8-21.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] s = new int[]{8,4,3,2,1,5};
        quicksort(s,0,s.length-1);
        for (int i = 0; i < s.length ; i++){
            System.out.println(s[i]);
        }
    }
    public static void quicksort(int[] s,int begin,int end){
        int index = partion(s,begin,end);
        if (index < end){
            quicksort(s,index+1,end);
        }
        if (index > begin){
            quicksort(s,begin,index-1);
        }
    }

    public static int partion(int[] s,int start,int end){
        int index = start;
        for (int i = start;i < end;i++){
            if (s[i] < s[end]){
                int temp = s[i];
                s[i] = s[index];
                s[index] = temp;
                index++;
            }
        }
        int temp = s[end];
        s[end] = s[index];
        s[index] = temp;

        return index;
    }
}
