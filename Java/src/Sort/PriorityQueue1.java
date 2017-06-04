package Sort;

import java.util.PriorityQueue;

/**
 * Created by 殷鑫 on 2017/6/2.
 */
public class PriorityQueue1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0; i <arr.length; i++ ){
            q.add(arr[i]);
        }
        int i = 0;
        while (!q.isEmpty()){
            arr[i++] = q.poll();
        }
    }
}
