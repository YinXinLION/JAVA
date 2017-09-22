package 去哪儿;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yinxin on 17-9-20.
 */
 class Node {
    Node left;
    Node right;
    int data;

    Node(int newData) {
        left = null;
        right = null;
        data = newData;
    }
}
public class test2 {
    public static Node buildTree(Node root, int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        }
        root = new Node(nums[index]);
        root.left = buildTree(root.left, nums, 2 * index + 1);
        root.right = buildTree(root.right, nums, 2 * index + 2);
        return root;
    }

    static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        int[] s = new int[1023];
        int index = 0;
        int end = 0;
        int flag = 0;
        s[index++] = data;
        while (scanner.hasNext()) {
            String t = scanner.next();
            t = t.substring(2);
            String[] w = t.split("\\|");


            Integer a = Integer.parseInt(w[0]);
            Integer b = Integer.parseInt(w[1]);
            if (a == -1 && flag == 0) {
                end = index;
                flag = 1;
            }
            s[index++] = a;
            if (b == -1 && flag == 0) {
                end = index;
                flag = 1;
            }
            s[index++] = b;
            if ((index) == (end * 2 + 1)) {
                break;
            }
        }

        Node root = buildTree(new Node(0), s, 0);
        if (isValidBST(root) == false) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }


    }

    public static boolean isValidBST(Node root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean valid(Node root, long low, long high) {
        if (root == null) return true;
        if (root.data <= low || root.data >= high) return false;
        return valid(root.left, low, root.data) && valid(root.right, root.data, high);
    }
}