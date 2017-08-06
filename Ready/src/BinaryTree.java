import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yinxin on 17-8-6.
 */
class Node{
    public int data;
    public Node left;
    public Node right;
    Node(int x){
        data =  x;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.left = b;a.right=c;     //      a
        b.left = d;b.right = null;//    b   c
        c.left = c.right = null;  //  d
        d.left = e;d.right = null;//e
        e.left = e.right = null;
        System.out.println("二叉树节点个数"+GetNodeNum(a));
        System.out.println("二叉树深度"+GetDeepth(a));
        //二叉树前序非递归
        preOrder(a);
        LevelTraverse(a);
    }

    //求二叉树中的节点个数
    public static int GetNodeNum(Node root){
        if (root == null){
            return 0;
        }
        return GetNodeNum(root.left)+GetNodeNum(root.right)+1;
    }

    //求二叉树深度
    public static int GetDeepth(Node root){
        if (root == null){
            return 0;
        }
        int left = GetDeepth(root.left);
        int right = GetDeepth(root.right);
        return Math.max(left,right)+1;
    }

    //二叉树前序遍历
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (!stack.isEmpty()||p!=null){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.data);
            p = p.right;
        }
    }

    //分层遍历
    public static  void LevelTraverse(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.data+"->");
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right!= null){
                queue.offer(cur.right);
            }

        }
    }
}
