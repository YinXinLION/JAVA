package LinkedList;


/**
 * Created by yinxin on 17-7-12.
 */
//移除倒数第几个节点
//我们可以利用两个指针同步后移，当后一个指针到达链表末尾时，前一个指针刚好指向待删除元素的前驱节点。
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode myHead = new ListNode(-1),p,q;
        myHead.next = head;
        p = myHead;
        q = myHead;

        while (n-- > 0){
            q = q.next;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return myHead.next;
    }
}
