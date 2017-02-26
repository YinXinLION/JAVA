package test;

/**
 * Created by 殷鑫 on 2017/2/26.
 */
//测试arraycopy
public class one1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.arraycopy(arr, 1, arr, 0, 3);
        //将arr数组第1个位置长度为3的3个元素移到位置0出
        //所以1被覆盖，变成2,3,4,4
        for (int i : arr){
            System.out.println(i);
        }

        System.out.println("==========");
        StringBuilder sb = new StringBuilder(16);
        System.out.println(sb.capacity());
        sb.append("hello");
        System.out.println(sb.length());
    }
}
