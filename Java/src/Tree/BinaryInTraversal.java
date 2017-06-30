package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yinxin on 17-6-24.
 */
//中序遍历
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
        //不断的加入左孩子
        while (p != null || !s.isEmpty()){
            while (p != null){
                s.push(p);
                p = p.left;
            }
            //取出栈顶
            p = s.pop();
            //打印
            list.add(p.data);
            //查看是否有右孩子
            p = p.right;
        }
        return list;
    }
}
