package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
//约瑟夫环
public class JosephusKill {
    //普通做法
    public Node Kill1(Node head, int m){
        if (head == null || head.next == head || m < 1){
            return  head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return  head;
    }
}
