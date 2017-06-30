package Tree;

import java.util.Map;

/**
 * Created by yinxin on 17-6-30.
 */
//判断最小深度 和 最大
public class DepthofBinaryTree {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.left = d;a.right = b;         //a
        b.left =  c;b.right = null;//  d    b
        c.left = c.right = null;//         c
                                //
        int Mindepth = new DepthofBinaryTree().doMinDepth(a);
        System.out.println(Mindepth);
        int Maxdepth = new DepthofBinaryTree().doMaxDepth(a);
        System.out.println(Maxdepth);

    }

    public int doMinDepth(Node root){
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = doMinDepth(root.left);
        int rigthDepth = doMinDepth(root.right);
        return 1+ Math.min(leftDepth,rigthDepth);
    }

    public int doMaxDepth(Node root){

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = doMaxDepth(root.left);
        int rigthDepth = doMaxDepth(root.right);

        return (1+Math.max(leftDepth,rigthDepth));
    }
}
