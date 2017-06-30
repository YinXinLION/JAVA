package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

/**
 * Created by yinxin on 17-6-25.
 */
//后序遍历
public class BinaryPostTraversal {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.left = null;a.right = b;
        b.left =  c;b.right = d;
        c.left = c.right = null;
        d.left = null; d.right = e;
        e.left = f; e.right = null;
        f.left = f.right = null;
        List<Integer> list = postOrderTraversal(a);
        for (Integer s : list){
            System.out.println(s);
        }
    }

    public static List<Integer>  postOrderTraversal(Node root){
        List<Integer> list = new LinkedList<>();
        Map<Node,Boolean> visit = new HashMap<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        Node p = root;
        //左右中
        while (p != null || !stack.isEmpty()){
            //首先不断的加入左孩子
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            // 对于任一结点P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点
            // ，此时该结点出现在栈顶，但是此时不能将其出栈并访问，因此其右孩子还未被访问。
            // 所以接下来按照相同的规则对其右子树进行相同的处理，当访问完其右孩子时，该结点又出现在栈顶，
            // 此时可以将其出栈并访问，这样才能保证了正确的访问顺序。可以看出，在这个过程中，
            // 右子数不为空的结点都会两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。
            // 因此需要利用哈希表来标识该结点是否是第一次出现在栈顶。
            p = stack.peek();
            if (p.right != null){
                if (visit.get(p) == null){
                    visit.put(p,true);
                    //第一次处理右子树
                    p = p.right;
                }else {
                    list.add(p.data);
                    stack.pop();
                    p = null;
                }
            }else {
                list.add(p.data);
                stack.pop();
                p = null;
            }
        }
        return list;
    }
}
