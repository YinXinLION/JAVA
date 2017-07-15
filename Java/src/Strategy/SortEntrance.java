package Strategy;

import java.util.Arrays;

/**
 * Created by yinxin on 17-7-15.
 */
public class SortEntrance {
    public static void main(String[] args) {
        int[] myArray = {1,4,3,7,5,8,6,2};
        Sorter s = new BubbleSorter();
        s.sort(myArray);
        Arrays.stream(myArray).forEach(System.out::println);
    }
}
