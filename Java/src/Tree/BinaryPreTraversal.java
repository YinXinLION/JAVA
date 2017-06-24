package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yinxin on 17-6-24.
 */
public class BinaryPreTraversal {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.left = null;a.right = b;
        b.left =  c;b.right = null;
        c.left = c.right = null;
        List<Integer> list = preTraversal(a);
        for (Integer s : list){
            System.out.println(s);
        }
    }
    // list输出结果
    public static List<Integer> preTraversal(Node root){
        List<Integer> list = new LinkedList<Integer>();
        if (root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                list.add(p.data);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        return list;
//        if (root == null){
//            return;
//        }
//        Stack<Node> s = new Stack<Node>();
//        Node current;
//
//        s.push(root);
//        while (! s.isEmpty()){
//            current = s.peek();
//
//        }


    }
}
