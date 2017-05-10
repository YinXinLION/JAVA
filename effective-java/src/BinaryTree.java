import java.util.LinkedList;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/3/22.
 */
public class BinaryTree {
    private int[] array = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    private static class Node{
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData){
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void createBinTree(){
        nodeList = new LinkedList<Node>();
        //将一个数组的值一次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        //对前lastParentIndex - 1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length/2 -1;parentIndex++){
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex*2+1);
            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex*2+2);
        }

        //最后一个父节点:因为左右一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length /2 - 1;
        //左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex*2+1);
        //右孩子
        if (array.length % 2 == 1){
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex*2+2);
        }
    }
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinTree();
        Node root = nodeList.get(0);
        preOrderTraverse(root);
    }
}
