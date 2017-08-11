package List;


/**
 * Created by yinxin on 17-8-11.
 */
//合并两个有序单链表
public class TwoToOne {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;b.next = null;
        Node c = new Node(5);
        Node d = merge(a,c);
        while (d!=null){
            System.out.println(d.value);
            d = d.next;
        }
    }
    public static Node merge(Node firstHead,Node secondHead){
        //退出条件
        if (firstHead == null){
            return secondHead;
        }
        if (secondHead == null){
            return firstHead;
        }
        //比较两个单链表的第一个节点，值小的节点作为合并后的链表的节点
        Node current = null;
        if (firstHead.value < secondHead.value){
            current = firstHead;
            current.next = merge(firstHead.next,secondHead);
        }else {
            current = secondHead;
            current.next = merge(firstHead,secondHead.next);
        }
        return current;
    }
}
