package ite;

import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Created by 殷鑫 on 2017/5/24.
 */
class Node<T>{
    public T data;
    public Node left;
    public Node right;
    public Node parent;
    public int state;
    public Node(T d){
        this.data = d;
    }
}

public class test<T> {
    Node<T> root;
    public static void main(String[] args) {
       Node a = new Node<Integer>(1);
       Node b = new Node<Integer>(2);
       Node c = new Node<Integer>(3);
       Node d = new Node<Integer>(4);
       Node e = new Node<Integer>(5);
       Node f = new Node<Integer>(6);

        a.parent = b;
        b.left = a;
        b.right = d;
        b.parent = f;
        c.parent = d;
        e.parent = d;
        d.parent = b;
        f.left = b;
        d.left = c;
        d.right = e;
        test<Integer> h = new test<Integer>();
        System.out.println(h.successor(e).data);

        h.remove(b);
        System.out.println(f.left.data);




    }

    public Node<T> successor(Node<T> n){
        if (n == null){
            return  null;
        }
        Node<T> p;
        if (n.right != null){
            p = n.right;
            while (p.left!=null){
                p = p.left;
            }
            return p;
        }else {  //如果没有右孩子 只能是父节点
            p = n.parent;        //如果是该节点时父亲的右孩子
            while (p != null && p.left != n){
                n = p;
                p = n.parent;

            }
            return  p;
        }
    }

    public void remove(Node<T> node){
        Node<T> p = node.parent; //node的父节点
        Node<T> next,child;
        //叶子节点，直接删除即可
        if (node.left == null && node.right == null){
            if (node == root){
                root = null;
                return;
            }
            if (node == p.left){ //如果左孩子
                p.left = null;
            }else if (node == p.right){//如果是右孩子
                p.right = null;
            }
        }else if (node.left !=null && node.right != null){ //如果待删除节点左右孩子都不是null
            next = successor(node);
            node.data = next.data;//将后继值赋给待删节点
            remove(next);//移除
        }else{//如果只有子节点
            if (node.left != null)
                child = node.left;//如果不是null，那么记录child是node左节点
            else
                child = node.right;//如果不是null，那么记录是node右节点

            if (node == root){   //如果node是null
                child.parent = null;//将node置为null
                root = child;//root变为他的孩子
                return;
            }
            //如果node不是root
            if (node == p.left){ //node是左孩子
                child.parent = p;//child的父节点是待删节点子左节点
                p.left = child;
            }else {
                child.parent = p;
                p.right = child;
            }
        }
    }
}
