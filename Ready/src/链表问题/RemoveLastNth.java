package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
public class RemoveLastNth {
    public Node removeLastKthNode(Node head, int lastKth){
        if (head == null||lastKth < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0){
            head = head.next;
        }
        //为负数,表示这个链表长度大于k
        if (lastKth < 0){
            cur = head;
            while (++lastKth !=0){
                cur = cur.next;
            }
            cur.next = cur.next.next;

        }
        return head;
    }
}
