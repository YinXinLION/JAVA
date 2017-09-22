package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
//删除链表中间节点
public class RemoceMidNode {
    public Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        Node pre = head;
        /*
            1       2          3     4    5      6     7    8
            head  head.next
             pre              cur
                   pre                  cur
                              pre                     cur
         */
        Node cur = head.next.next;
        //长度为3 删除第2个
        //链表长度为4 删除第2个
        //长度为5，删除第3个
        //cur后面有2个，pre走一下 然后删除pre后面的即可
        while (cur.next!=null && cur.next.next!=null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
