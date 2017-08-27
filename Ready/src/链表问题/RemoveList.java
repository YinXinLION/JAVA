package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
public class RemoveList {
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        /*
             1 -> 2 -> 3 -> 4
                next -> 2;
                   head(1) -> null
                   pre -> 1;
                   head -> 2;
         */
        //很强
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    //下面是双链表的翻转  666
    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return  pre;
    }
}
