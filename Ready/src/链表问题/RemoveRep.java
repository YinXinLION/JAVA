package 链表问题;

import java.util.HashSet;

/**
 * Created by yinxin on 17-8-28.
 */
//删除无序单链表中值重复出现的节点
public class RemoveRep {
    public void removeRep1(Node head){
        if (head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null){
            if (set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}
