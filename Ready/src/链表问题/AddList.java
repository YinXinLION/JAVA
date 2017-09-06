package 链表问题;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-28.
 */
/*
    链表的相加操作
    每个条链表表示一个整数
    1.将各自链表压入各自栈中
    2.开始循环取出(当栈都为null时结束循环)
        查看s1的栈是否为null 如果为null表示0，不为null表示具体数
        同理s2也取出
    3.一个表示前驱，一个表示当前节点
        node当前位置为null 赋值给pre
        new Node(data) 然后 将node.next = pre
        注意 要得到进位标志
        2 开始重复
    4.查看 进位是否为1 为1 则再new 一个
 */
public class AddList {
    public Node addList1(Node head1,Node head2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1!=null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2!=null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre =  null;
        while (!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0:s1.pop();
            n2 = s2.isEmpty() ? 0:s2.pop();
            n = n1+n2+ca;
            /*
                             pre(null)
                 new Node -> pre(null)
                 pre(Node)
           new Node -> pre
             */
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
        }
        if (ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }
}
