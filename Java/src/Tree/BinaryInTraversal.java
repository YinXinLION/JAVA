package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yinxin on 17-6-24.
 */
public class BinaryInTraversal {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.left = null;a.right = b;
        b.left =  c;b.right = null;
        c.left = c.right = null;
        List<Integer> list = inTraversal(a);
        for (Integer s : list){
            System.out.println(s);
        }
    }
    public static List<Integer> inTraversal(Node root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        Node p = root;
        while (p != null || !s.isEmpty()){
            while (p != null){
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            list.add(p.data);
            p = p.right;
        }
        return list;
    }
}
