package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yinxin on 17-6-25.
 */
public class BinaryLevelOrder {
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
        List<List<Integer>> lists = levelOrder(a);
        for (List<Integer> list : lists){
            for (Integer s : list){
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            Queue<Node> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                Node node = queue.poll();
                list.add(node.data);
                if (node.left != null) nextQueue.add(node.left);
                if (node.right != null) nextQueue.add(node.right);
            }
            queue = nextQueue;
            levels.add(list);
        }
        return levels;
    }
}
