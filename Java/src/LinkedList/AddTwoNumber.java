package LinkedList;

import java.util.List;

/**
 * Created by yinxin on 17-7-12.
 * 有两个链表作为输入，它们表示逆序的两个非负数。
 * 如下面的两个链表表示的是342和465这两个数。
 * 你需要计算它们的和并且用同样的方式逆序输出。
 * 如342+465 = 807,你需要把结果表达为7 ->0 ->8
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode a = new ListNode(3);
        l1.next = a;
        ListNode l2 = new ListNode(3);
        ListNode b = new ListNode(4);
        l2.next = b;
        ListNode head = addTowNumbers(l1,l2);
        System.out.println(head.val);
        System.out.println(head.next.val);

    }
    public static ListNode addTowNumbers(ListNode l1,ListNode l2){
        ListNode myHead = new ListNode(-1);
        ListNode last = myHead;
        ListNode p = l1, q = l2;
        int add = 0;
        while (p!= null || q !=null){
            int sum = add + (p==null?0:p.val)+(q==null?0:q.val);
            add = sum/10;//进位的
            ListNode t = new ListNode(sum%10);
            last.next = t;
            last = t;
            if (p!=null) p = p.next;
            if (q!=null) q = q.next;
        }
        //最后的进位
        if (add != 0){
            ListNode t = new ListNode(add);
            last.next = t;
            last = t;
        }
        return myHead.next;
    }
}
