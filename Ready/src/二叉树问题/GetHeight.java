package 二叉树问题;

/**
 * Created by yinxin on 17-8-30.
 */
public class GetHeight {
    //第一种方法
    boolean isBalanced(Node node){
        return maxDeath1(node)!=-1;
    }
    int maxDeath1(Node node){
        if (node == null){
            return 0;
        }
        int left = maxDeath1(node.left);
        int right = maxDeath1(node.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > -1){
            return -1;
        }
        return Math.max(left,right)+1;
    }


    //第二种方法
    public boolean isBalance(Node head){
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }
    /*
        这道题使用后序遍历，先遍历左子树，找到lH高度，然后遍历右子树找到rH高度
        然后比较左右子树的高度，如果>1将res[0]改为false；
        在每次遍历过程中都要判断以便res[0]这样可以立即返回。

     */
    public int  getHeight(Node head, int level, boolean[] res){
        if (head == null){
            return level;
        }
        int lH = getHeight(head.left, level+1, res);
        if (!res[0]){
            return level;
        }
        int rH = getHeight(head.right, level+1, res);
        if (!res[0]){
            return level;
        }
        if (Math.abs(lH - rH) > 1){
            res[0] = false;
        }
        return Math.max(lH,rH);
    }
}
