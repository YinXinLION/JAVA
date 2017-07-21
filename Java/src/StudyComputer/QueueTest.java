package StudyComputer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yinxin on 17-7-21.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new LinkedList<>();

        queue.offer("a");
        queue.offer("c");
        queue.offer("b");

        while (queue.peek() != null){
            System.out.println(queue.poll());
        }
    }
}
