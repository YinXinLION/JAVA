package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
public class RemoveLastKthNode {
    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if (head == null || lastKth< 1){
            return head;
        }
        DoubleNode cur = head;
        while (cur!=null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0){
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0){
            cur = head;
            while (++lastKth!=0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }

    //进阶没看
}
