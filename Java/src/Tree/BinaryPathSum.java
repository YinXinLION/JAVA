package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

/**
 * Created by yinxin on 17-6-25.
 */
public class BinaryPathSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSum(Node root,int sum){
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Map<Node,Boolean> visit = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        int nowSum = 0;
        Node p = root;
        while (p != null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                nowSum += p.data;
                p = p.left;
            }
            p = stack.peek();
            if (p.left==null && p.right == null && sum== nowSum){
                List<Integer> r = new ArrayList<>();
                for (Object i : stack.toArray()){
                    r.add((Integer)((Node)i).data);
                }
                lists.add(r);
            }
            if (p.right != null){
                if (visit.get(p) == null){
                    visit.put(p,true);
                    p = p.right;
                }else {
                    nowSum -= p.data;
                    stack.pop();
                    p = null;
                }
            }else {
                nowSum -= p.data;
                stack.pop();
                p = null;
            }
        }
        return lists;
    }
}
