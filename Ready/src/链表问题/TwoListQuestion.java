package 链表问题;

/**
 * Created by yinxin on 17-8-28.
 */
//两个单链表相交的一系列问题
public class TwoListQuestion {
    //但链表是否有环，有环求出第一个进入环的节点
    public Node getLoopNode(Node head){
        if (head == null||head.next ==null||head.next.next==null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2){
            if (n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //判断两个无环链表是否相交
    public Node noLoop(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){ //如果不想交
            return null;
        }
        //相交
        //n>0 head1长 否则head2长
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ?head2:head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //判断2个有环链表是否相交，相交返回第一个相交节点
    public Node bothLoop(Node head1,Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0?head1:head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }
}
