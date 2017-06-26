package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.TreeMap;

/**
 * Created by yinxin on 17-6-26.
 */
//二叉树的构建 已知前序和中序
public class BinaryConstruct {
    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{1,3,2};
        Node root = buildTree(preorder,inorder);
        System.out.println(root.data);
        System.out.println(root.right.data);
        System.out.println(root.right.left.data);
    }

    public static Node buildTree(int[] preorder,int[] inorder){
        int n = preorder.length;
        if (n == 0) return null;
        return doBuildTree(preorder,0,n-1,inorder,0,n-1);
    }

    public static Node doBuildTree(int[] preorder,int s1,int e1,int[] inorder,int s2, int e2){
        if (e1<s1) return  null;
        int rootIndex = 0;
        for (int i = s2;i <= e2;i++){
            if (inorder[i] == preorder[s1]){
                rootIndex = i; //找到根节点在中序数组中的坐标
                break;
            }
        }
        int leftCount = rootIndex - s2;//找到后，rootIndex-s2得到左子树的个数
        Node root = new Node(preorder[s1]); //建立根节点
        //前序遍历数组只能从s1+1开始，长度为s1+leftCount ，中序起点（左边） 从s2开始到 rootIndex -1
        root.left=doBuildTree(preorder,s1+1,s1+leftCount,inorder,s2,rootIndex-1);
        root.right=doBuildTree(preorder,s1+leftCount+1,e1,inorder,rootIndex+1,e2);
        return root;
    }


}
