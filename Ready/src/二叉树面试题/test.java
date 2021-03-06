package 二叉树面试题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yinxin on 17-8-18.
 */
/*
                 3
             20     9
          15   17
              8
 */
public class test {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(17);
        TreeNode f = new TreeNode(8);
        a.right = c; a.left = b;
        b.left = b.right = null;
        c.left = d ; c.right = e;
        d.left = d.right = null;
        e.left = f ;e.right = null;
        f.left = f.right = null;
        System.out.println(maxDepth(a));
        System.out.println(minDepth(a));
        System.out.println(numOfTreeNode(a));
        System.out.println("叶子节点数量"+numOfNoChildNode(a));
        System.out.println("二叉树中第K层节点的个数"+numOfLevelTreeNode(a,2));
        System.out.println(isBalanced(a));
    }
    //二叉树中序遍历
    public static ArrayList inOrder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current!=null ||!stack.isEmpty()){
            while (current!=null){
                stack.add(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }
    //后序遍历
    public static ArrayList<Integer> postOrder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        list.addAll(postOrder(root.left));
        list.addAll(postOrder(root.right));
        list.add(root.val);
        return list;
    }

    //翻转二叉树Or镜像二叉树
    public static TreeNode mirrorTreeNode(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode left = mirrorTreeNode(root.left);
        TreeNode right = mirrorTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    //二叉树前序遍历
    public static ArrayList<Integer> preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left !=null){
                stack.push(node.left);
            }
        }
        return list;
    }

/*
    //求两个二叉树的最低公共祖先节点
    public static TreeNode getLastCommonParent(TreeNode root,TreeNode t1,TreeNode t2){

    }
*/

    //两个二叉树是否互为镜像
    public static boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1==null && t2==null){
            return true;
        }
        if (t1 == null || t2== null){
            return false;
        }
        if (t1.val!=t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }



    //判断两个二叉树是否完全相同
    public static boolean isSameTreeNode(TreeNode t1,TreeNode t2){
        if (t1 == null &&  t2 == null){
            return true;
        }else if (t1 == null || t2 == null){
            return false;
        }
        if (t1.val!=t2.val){
            return false;
        }
        boolean left = isSameTreeNode(t1.left,t2.left);
        boolean right = isSameTreeNode(t1.right,t2.right);
        return left&right;
    }
    //判断二叉树是否是完全二叉树
//    public static boolean isCompleteTreeNode(TreeNode root){
//        if (root == null){
//            return false;
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        boolean result = true;
//        boolean hasNoChild = false;
//        while (!queue.isEmpty()){
//            TreeNode current = queue.remove();
//            if (hasNoChild){
//                if (current.left!=null||current.right!=null){
//                    result = false;
//                    break;
//                }
//            }else {
////                if (current.left!=null)
//            }
//        }
//    }
    //判断二叉树是否为平衡二叉树
    public static boolean isBalanced(TreeNode node){
        return maxDeath2(node)!=-1;
    }
    public static int maxDeath2(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = maxDeath2(node.left);
        int right = maxDeath2(node.right);
        if (left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    //求二叉树中第K层节点的个数
    public static int numOfLevelTreeNode(TreeNode root ,int k){ //k是层数
        if (root == null || k < 1){
            return 0;
        }
        if (k == 1){  //如果k==1,返回1
            return 1;
        }
        int numleft = numOfLevelTreeNode(root.left,k-1);//左右递归到k=1
        int numright = numOfLevelTreeNode(root.right,k-1);
        return numleft+numright;
    }

    //求二叉树最大深度
    public static int maxDepth(TreeNode root){
        if (root==null){//如果为null返回
            return 0;
        }
        int left = maxDepth(root.left);//得到左高度
        int right = maxDepth(root.right);//右高度
        return Math.max(left,right)+1;//高度最大的+1
    }
    //求二叉树最小深度
    public static int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.min(left,right)+1;//找到最小的+1
    }

    //求二叉树中节点个数
    public static int numOfTreeNode(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = numOfTreeNode(root.left);//得到最孩子高度
        int right = numOfTreeNode(root.right);//得到右孩子高度
        return left+right+1;
    }

    //求二叉树中叶子节点的个数
    public static int numOfNoChildNode(TreeNode root){
        if (root == null){//如果root为null 返回0就行
            return 0;
        }
//        System.out.println(root.val);
        if (root.left == null && root.right == null){ //如果root.left和root.right都为null,返回1
            return 1;
        }
        return numOfNoChildNode(root.left)+numOfNoChildNode(root.right);
    }

}
