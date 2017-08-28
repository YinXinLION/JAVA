package 链表问题;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-28.
 */
//删除指定的节点
public class RemoveValue {
    public Node removeValue1(Node head, int num){
        Stack<Node>  stack = new Stack<Node>();
        while (head!=null){
            if (head.value != num){
                stack.push(head);
            }
            head = head.next;
        }
        /*
            delete 3
           1->2->3->4
           1  2  4
           4.next = null;
           head = 4;
           3.next = 4;
           head = 3;

           6666
         */
        while (!stack.isEmpty()){
            stack.peek().next = head;
        }
        return head;
    }
}
