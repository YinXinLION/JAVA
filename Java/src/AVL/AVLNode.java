package AVL;

/**
 * Created by 殷鑫 on 2017/6/7.
 */
public class AVLNode {
    public int data;
    public AVLNode parent;
    public AVLNode left;
    public AVLNode right;

    public int depth;//深度
    public int balance;//平衡因子

    public AVLNode(int data){
        this.data = data;
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }

    private void insert(AVLNode root, int data){
        if (data < root.data){
            if (root.left != null)
                insert(root.left,data);
            else {
                root.left = new AVLNode(data);
                root.left.parent = root;
            }
        }else {
            if (root.right != null)
                insert(root.right, data);
            else {
                root.right = new AVLNode(data);
                root.right.parent = root;
            }
        }
        root.balance = calcBalance(root);

        //左子树高
        if (root.balance >= 2){
            if (root.left.balance == -1)
                left_rotate(root.left);
            right_rotate(root);
        }
        //右子树高
        if (root.balance <= -2){
            if (root.right.balance == 1)
                right_rotate(root.right);
            left_rotate(root);
        }

    }
    private void left_rotate(AVLNode p){

    }
    private void right_rotate(AVLNode p){
        AVLNode pParent = p.parent, pRightSon = p.left;
        AVLNode pLeftGrandSon = pRightSon.right;

        //左子变父
        pRightSon.parent = pParent;
        if (pParent != null){
            if (p == pParent.left) //如果p是左孩子
                pParent.left = pRightSon;
            else if (p == pParent.right) //如果p是右孩子
                pParent.right = pRightSon;
        }
        //把p挂到右孩子上
        pRightSon.right = p;
        p.parent = pRightSon;

        //右孙(p左孩子的右孩子)变左孙(右孩子的左孩子)
        p.left = pLeftGrandSon;
        if (pLeftGrandSon != null){
            pLeftGrandSon.parent = p;
        }
        //重新计算平衡因子
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);

        pRightSon.depth = calcDepth(pRightSon);
        pRightSon.balance = calcBalance(pRightSon);
    }


    private int calcDepth(AVLNode p){
        int depth = 0;
        if (p.left  != null)
            depth = p.left.depth;

        if (p.right !=  null && depth < p.right.depth)
            depth = p.right.depth;
        //找到depth最大的

        depth++;
        return depth;
    }

    private int calcBalance(AVLNode p){
        int left_depth;
        int rigth_depth;

        if (p.left != null)
            left_depth = p.left.depth;
        else
            left_depth = 0;

        if (p.right != null)
            rigth_depth = p.right.depth;
        else
            rigth_depth = 0;

        return left_depth - rigth_depth;
    }
}
