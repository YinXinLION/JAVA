package Strategy;

/**
 * Created by yinxin on 17-7-15.
 */
//冒泡
public class BubbleSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] < arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
