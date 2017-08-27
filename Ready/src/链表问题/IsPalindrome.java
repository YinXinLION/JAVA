package 链表问题;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-27.
 */
//判断一个链表是否是回文
public class IsPalindrome {

    //用栈来实现倒序
    public boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head!= null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        //找到一半的下一个
        while (cur.next!=null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right!=null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
