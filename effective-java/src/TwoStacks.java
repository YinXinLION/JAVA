import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 殷鑫 on 2017/3/15.
 */
public class TwoStacks {

    public static void main(String[] args) {
        int[] numbers = new int[]{7,2,5,9};
        twoStacksSort(numbers);
    }
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        int length = numbers.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        int index = 0;
        int current = numbers[index];
        stack.push(current);
        index++;

        while(index <= length -1){
            int start = index - 1;
            current = numbers[index]; //获取要插入的锇元素
            //如果栈顶大
            while(stack.peek()!= null && stack.peek() > current){
                numbers[start] = stack.pop();
                start--;
            }
            start++;
            stack.push(current);
            while(start < index){
                stack.push(numbers[start]);
                start++;
            }
            index++;
        }

        ArrayList<Integer> array = new ArrayList<>(length);
        while(stack.peek()!=null){
            System.out.println(stack.pop());
        }
        return array;

    }
}