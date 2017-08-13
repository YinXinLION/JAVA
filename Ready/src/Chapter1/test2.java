package Chapter1;

/**
 * Created by yinxin on 17-8-13.
 */
//失败 java引用太厉害写不了
    //链表翻转
public class test2 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.next = b;b.next=c;c.next=d;d.next=e;e.next=f;f.next=null;
        int k = 3;
        ReverseLink(a,k);
    }
    public static void ReverseLink(Node head, int k){
        if (head.next == null || head == null){
            return;
        }
        int count = 1;
        Node p,q,r = null,first = null;
        p  = head;
        q =  head.next;
        //前k个节点翻转
        while ((k > count)&&(q!=null)){
            r = q.next;
            q.next=p;
            p = q;
            q = r;count++;
        }
        first = r;
        head = p;
        Node p1,q1;
        p1 = first;
        q1 = p1.next;
        while(q1!=null){
            r = q1.next;
            q1.next = p1;
            p1 = q1;
            q1 = r;
        }
        first.next = null;
        System.out.println(p.data);

        while (head!=null){
            System.out.println(head.data);
            head = head.next;
        }

    }

}
