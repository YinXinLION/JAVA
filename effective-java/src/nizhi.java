/**
 * Created by 殷鑫 on 2017/4/6.
 */
class Node{
    public int data;
    public Node next;
}
public class nizhi {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        Node head = init(array);
//        show(head);
        Node niHead = nizhi(head);
        show(niHead);
    }
    public static Node nizhi(Node head){
        Node p = head;
        Node q = p.next;
        p.next = null;
        while (q != null){
            Node start = q.next;
            q.next = p;
            p = q;
            q = start;
        }
        return p;
    }
    public static Node init(int[] array){
        Node head = new Node();
        Node p = head;
        for (int i = 0; i < array.length; i++){
            p.data = array[i];
            p.next = new Node();
            if (i == array.length -1){
                p.next = null;
                break;
            }
            p = p.next;
        }
        return head;
    }
    public static void show(Node head){
        Node p = head;
        while (p!=null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}
