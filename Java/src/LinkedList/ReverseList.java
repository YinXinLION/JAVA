package LinkedList;

/**
 * Created by yinxin on 17-7-15.
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        ListNode head = reverseList(a);
        while (head!= null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    public static ListNode reverseList(ListNode head) {

        ListNode p = head,q = p.next,temp;
        while(q != null){

            temp = q.next;
            q.next = p;
            if(p == head){
                p.next = null;
            }
            p = q;
            q = temp;
        }
        head = p;
        return head;
    }
}

