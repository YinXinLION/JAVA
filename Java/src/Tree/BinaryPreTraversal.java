package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yinxin on 17-6-24.
 */
//前序遍历
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
        //创建一个链表，用来表示输出的先后顺序
        List<Integer> list = new LinkedList<Integer>();
        if (root == null){
            return list;
        }
        //栈
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()){
            //如果p不是空,那么左孩子循环加入栈，并且加入list中
            //因为先序 中左右
            while (p != null){
                list.add(p.data);
                stack.push(p);
                p = p.left;
            }
            //因为已经把最左的加入了,那么取出来栈顶，然后查看是否有右孩子
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
