package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinxin on 17-6-27.
 */
//验证一个二叉树是否是二叉查找树
    //1.左子树的值都比根节点小
    //2.右子树的值都比根节点大
    //3.左右子树都必须满足上面两个条件
public class ValidateBinaryTree {
    List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {

    }


    public boolean isValidateBST(Node root){
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        inOrderTraversal(root);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) <= list.get(i-1))
                return false;
        }
        return true;
    }
    public void inOrderTraversal(Node root){
        if (root == null)
            return;
        inOrderTraversal(root.left);
        list.add(root.data);
        inOrderTraversal(root.right);
    }

    //每次取一个判断所有的是否是比他小，或者比他大
    //然后取左孩子，或者右孩子再次判断所有的n-2个的
    // --------暴力破解
    public boolean isValidBST(Node root) {
        if (root == null) return true;
        if (!dfsLeft(root.left, root.data) || !dfsRight(root.right, root.data)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean dfsLeft(Node root, int value) {
        if (root == null) return true;
        if (root.data >= value) return false;
        return dfsLeft(root.left, value) && dfsLeft(root.right, value);
    }

    public boolean dfsRight(Node root, int value) {
        if (root == null) return true;
        if (root.data <= value) return false;
        return dfsRight(root.left, value) && dfsRight(root.right, value);
    }
    //-------------------------------------------------------------
}
