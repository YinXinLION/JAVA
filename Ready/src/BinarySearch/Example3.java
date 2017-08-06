package BinarySearch;

/**
 * Created by yinxin on 17-8-6.
 */
//查找最后一个与key相等
public class Example3 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,4,5,6,7};
        System.out.println(binarySerach(array,3));
    }
    static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (array[mid] <= key){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        if (right<array.length&& array[right]==key){
            return right;
        }
        return -1;
    }
}
