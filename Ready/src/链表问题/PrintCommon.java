package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
//打印有序链表公共部分
    /*
        如果head1.value > head2.value 那么 head2往下走
        如果head1.value < head2.value 那么 head1往下走
        当相等时开始
     */
public class PrintCommon {
    public void printCommonPart(Node head1, Node head2){
        System.out.println("Common Part");
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                head1 = head1.next;
            }else if (head1.value > head2.value){
                head2 = head2.next;
            }else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
