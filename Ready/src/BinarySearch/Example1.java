package BinarySearch;

/**
 * Created by yinxin on 17-8-6.
 */
//普通二分法
public class Example1 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        System.out.println(binarySerach(array,3));
    }
    static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length;
        while (left<=right){
            int mid = (left+right)/2;
            if (array[mid] == key){
                return mid;
            }else if (array[mid] < key){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }


}
