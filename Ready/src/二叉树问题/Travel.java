package 二叉树问题;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-28.
 */
//二叉树的前中后序递归非递归的遍历
public class Travel {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.left = b; a.right = null;
        b.left = b.right = null;
        preOrderRecur(a);

    }
    //前序递归
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.println("我在这1");
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        System.out.println("我在这2");
        preOrderRecur(head.right);
        System.out.println("我在这3");
    }
    public void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public void  posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    public void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right!=null){
                    stack.push(head.right);
                }
                if (head.left!=null){
                    stack.push(head.left);
                }
            }
        }
    }

    public void inOrderUnRecur(Node head){
        System.out.println("in-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head.left);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    public void posOrderUnRecur1(Node head){
        System.out.println("pos");
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop()+ " ");
            }
        }
        System.out.println();
    }
}
