package 链表面试题;

import java.util.List;

/**
 * Created by yinxin on 17-8-19.
 */
public class test {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next=b;b.next=c;c.next=d;d.next=e;e.next=null;
//        print(reverse(a));
//        System.out.println(hasCycle(a));
//        System.out.println(nthToLast(a,3).val);
    }
    //删除链表倒数第n个节点
    public static ListNode deletenthNode(ListNode head,int n){
        if (n <= 0){
            return null;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode preDel = dumy;
        for(int i = 0;i < n; i++){
            if (head == null){
                return null;
            }
            head = head.next;
        }
        //head跳到第n+1个位置
        while (head!=null){
            head = head.next;
            preDel = preDel.next;
        }
        preDel.next = preDel.next.next;
        return  dumy.next;
    }
    //得到链表倒数第n个节点
    public static ListNode nthToLast(ListNode head, int n){
        if (head == null || n < 1){
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < n-1;i++){
            if (l2 == null){
                return null;
            }
            l2 = l2.next;
        }

        while (l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }


    //判断链表是否有环
    public static boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow,fast;
        fast = head.next;
        slow = head;
        while (fast!=slow){
            if (fast==null || fast.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    //翻转链表一
    public static ListNode reverse(ListNode node){
        ListNode prev = null;
        while (node != null){
            ListNode tmp = node.next; // tmp是node的下一个
            node.next = prev;//node的下一个指向null
            prev = node;//prev赋值为node
            node = tmp;//node变为node的下一个
        }
        return prev;
    }
    public static void print(ListNode node){
        while (node!=null){
            System.out.print(node.val + "  ");
            node = node.next;
        }System.out.println();
    }
}
