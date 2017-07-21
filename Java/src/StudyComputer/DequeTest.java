package StudyComputer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yinxin on 17-7-21.
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque stack = new LinkedList();
        stack.push("a");
        stack.push("c");
        stack.push("b");
        while (stack.peek()!=null){
            System.out.println(stack.pop());
        }
    }
}
