package BinarySearch;

/**
 * Created by yinxin on 17-8-6.
 */
//查找最后一个等于或者小于key的元素

public class Example4 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,4,5,6,7};
        System.out.println(findLastEqualSmaller(array,3));
    }
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
}
