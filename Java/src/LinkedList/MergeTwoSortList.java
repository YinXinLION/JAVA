package LinkedList;

/**
 * Created by yinxin on 17-7-12.
 */
//
public class MergeTwoSortList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode myHead = new ListNode(-1), last = myHead, p,q,t;
        p = l1;
        q = l2;
        while (p!=null||q!=null){
            if (q==null ||(p!=null&&p.val <= q.val)){
                t = p;
                p = p.next;
            }else {
                t = q;
                q = q.next;
            }
            t.next = null;
            last.next = t;
            last = t;
        }
        return myHead.next;
    }
}
