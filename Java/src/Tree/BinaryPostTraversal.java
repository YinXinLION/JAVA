package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

/**
 * Created by yinxin on 17-6-25.
 */
public class BinaryPostTraversal {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.left = null;a.right = b;
        b.left =  c;b.right = null;
        c.left = c.right = null;
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
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
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
