package 二叉树问题;

/**
 * Created by yinxin on 17-8-30.
 */
public class LowestAncestor {
    public Node lowestAncestor1(Node head,Node o1,Node o2){
        if (head == null || head == o1 || head == o2){
            return head;
        }
        Node left = lowestAncestor1(head.left,o1,o2);
        Node right = lowestAncestor1(head.right,o1,o2);
        if (left != null && right != null){ //如果left right都不为null 那么都找到了 head 就是祖先节点
            return head;
        }
        return left!=null ? left : right; //如果left不为null，right为null 那么返回left因为left找到了
    }
}
