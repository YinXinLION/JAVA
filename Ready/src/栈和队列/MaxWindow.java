package 栈和队列;

import java.util.LinkedList;

/**
 * Created by yinxin on 17-8-26.
 */
public class MaxWindow {
    public int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1|| arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i-w){
                qmax.pollLast();
            }
            if (i >= w -1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
