package Chapter3;

/**
 * Created by yinxin on 17-8-14.
 */
//公共祖先问题
public class test1 {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(7);
        a.left = b;a.right =  null;
        b.left=c;b.right = d;
        c.left=c.right=d.left=d.right=null;
        System.out.println(query(a,a,b));
    }

    //first是二叉查找树
    /*
    如果当前结点t 大于结点u、v，说明u、v都在t 的左侧，所以它们的共同祖先必定在t 的左子树中，故从t 的左子树中继续查找；
    如果当前结点t 小于结点u、v，说明u、v都在t 的右侧，所以它们的共同祖先必定在t 的右子树中，故从t 的右子树中继续查找；
    如果当前结点t 满足 u <t < v，说明u和v分居在t 的两侧，故当前结点t 即为最近公共祖先；
    而如果u是v的祖先，那么返回u的父结点，同理，如果v是u的祖先，那么返回v的父结点。
     */
    public static int query(Node t,Node u,Node v){
        int left = u.value;
        int right = v.value;
        //二叉查找树内，如果左结点大于右结点，不对，交换
        if (left>right){
            int temp = left;
            left = right;
            right = left;
        }
        while (true){
            if (t.value < left){
                t = t.right;
            }else if (t.value > right){
                t = t.left;
            }else {
                return  t.value;
            }
        }
    }
}
