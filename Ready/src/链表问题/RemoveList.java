package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
public class RemoveList {
    /*
    类把我看懵逼了 这个时用来翻转链表的
    记录当前的前一个 和后一个
    while(head!=null)
    记录下一个节点
    当前节点指向pre
    更新pre = 当前节点
    更新当前节点 = head
     */
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
