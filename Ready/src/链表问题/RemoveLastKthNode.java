package 链表问题;

/**
 * Created by yinxin on 17-8-27.
 */
public class RemoveLastKthNode {
    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if (head == null || lastKth< 1){
            return head;
        }
        DoubleNode cur = head;
        //循环一遍找到多出来的 即为要从头向下走的步数
        while (cur!=null){
            lastKth--;
            cur = cur.next;
        }
        //如果lastKth ==0 代表要删除的是第一个节点
        if (lastKth == 0){
            head = head.next;
            head.last = null;
        }
        //如果lastKth <0，代表要走多少布
        if (lastKth < 0){
            cur = head;
            while (++lastKth!=0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }

    //进阶没看
}
