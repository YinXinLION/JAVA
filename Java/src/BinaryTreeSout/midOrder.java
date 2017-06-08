package BinaryTreeSout;

import java.util.Stack;

/**
 * Created by 殷鑫 on 2017/6/7.
 */
class Node{
    public Object data;
    public Node left = null;
    public Node right = null;
    public int state = 0;
}

public class midOrder {
    public static Node root;
    public static void main(String[] args) {
        Node a = new Node();
        a.data = 1;
        Node b = new Node();b.data = 2;
        Node c = new Node();c.data = 3;
        Node d = new Node();d.data = 4;
        Node e = new Node();e.data = 5;
        Node f = new Node();f.data = 6;
        Node g = new Node();g.data = 7;
        root = a;
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
//        new midOrder().midOrderFind();
//        new midOrder().preOrder();
        new midOrder().lastFind();
    }


    public void lastFind(){
        if (root == null)
            return;
        Stack<Node> s  = new Stack<>();
        Node current;
        s.push(root);
        while (!s.isEmpty()){
            current = s.peek();
            if (current.state == 0){
                    if (current.left != null)
                    s.push(current.left);
                    current.state = 1;
            }else if (current.state == 1){
                    if (current.right != null)
                    s.push(current.right);
                    current.state = 2;
            }else if (current.state == 2){
                    System.out.println(current.data);
                    current.state = 3;
            }else if (current.state == 3){
                    s.pop();
            }
        }
    }

    public void midOrderFind(){
        if (root == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        Node current;
        //先将root放入栈中
        s.push(root);
        //如果栈不空，while循环
        while (!s.isEmpty()){
            //取出栈
                current = s.peek();
                if (current.state == 0){
                    if (current.left != null){
                        s.push(current.left);
                    }
                    current.state = 1;
                }else if (current.state == 1){
                    System.out.print(current.data + "  ");
                    current.state = 2;
                }else if (current.state == 2){
                    if (current.right != null)
                        s.push(current.right);
                    current.state = 3;
                }else  if (current.state == 3){
                    s.pop();
                }
        }
    }

    public void preOrder(){
        if (root == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        Node current;
        //先将root放入栈中
        s.push(root);
        while (!s.isEmpty()){
            current = s.peek();
            if (current.state == 0){
                System.out.print(current.data + "  ");
                current.state = 1;
            }else if (current.state == 1){
                if (current.left != null)
                    s.push(current.left);
                current.state = 2;
            }else if (current.state == 2){
                if (current.right != null)
                    s.push(current.right);
                current.state = 3;
            }else if (current.state == 3){
                s.pop();
            }
        }
    }


}


