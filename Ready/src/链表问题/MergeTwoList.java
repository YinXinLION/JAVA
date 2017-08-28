package 链表问题;

/**
 * Created by yinxin on 17-8-28.
 */
public class MergeTwoList {
    //合并两个有序的单链表
    public Node merge(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return  head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1:head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2!=null){
            if (cur1.value <= cur2.value){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;    // pre -> cur2
                cur2.next = cur1;   //cur2 -> cur1
                pre = cur2;         // pre(cur2)
                cur2 = next;        //cur2(cur2.next)
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
