package 二叉树问题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yinxin on 17-8-28.
 */
public class SerialByPre {
    //序列化
    public String serialByPre(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return  res;
    }
    //反序列化
    public Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++){
            queue.offer(values[i]);
        }
        return  reconPreOrder(queue);
    }
    public Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
