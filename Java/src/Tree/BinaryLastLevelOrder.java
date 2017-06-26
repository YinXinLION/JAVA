package Tree;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by yinxin on 17-6-25.
 */
//按层遍历 倒叙
public class BinaryLastLevelOrder {
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(9);
        Node c = new Node(20);
        Node d = new Node(15);
        Node e = new Node(17);
        a.right = c; a.left = b;
        b.left = b.right = null;
        c.left = d ; c.right = e;
        d.left = d.right = null;
        e.left = e.right = null;
        List<List<Integer>> lists = lastLevelOrder(a);
        Stack<List<Integer>> stack = new Stack<>();
        for (List<Integer> list : lists){
            stack.push(list);
        }
        while (!stack.isEmpty()){
            List<Integer> list = stack.pop();
            for (Integer s : list){
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> lastLevelOrder(Node root){
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<Node> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                Node q = queue.poll();
                list.add(q.data);
                if (q.left != null) nextQueue.add(q.left);
                if (q.right != null) nextQueue.add(q.right);
            }
            queue = nextQueue;
            lists.add(list);
        }
        return lists;
    }
}
