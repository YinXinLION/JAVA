package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
public class ReversePart {
    public Node reversePart(Node head, int from, int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        //先找到from前面那个 和 to后面那个
        while (node1 != null){
            len++;
            fPre = len == from-1?node1:fPre;
            tPos = len == to+1?node1:tPos;
            node1 = node1.next;
        }
        //如果错误的话直接返回head
        if (from > to || from < 1 || to > len){
            return  head;
        }
        //找到fPre的下一个节点 from节点
        node1 = fPre == null?head:fPre.next;
        //from的下一个节点
        Node node2 = node1.next;
        //from节点的next是tPos
        node1.next = tPos;
        Node next = null;
        while (node2 != null){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null){
            fPre.next = node1;
            return  head;
        }
        return  node1;


    }
}
