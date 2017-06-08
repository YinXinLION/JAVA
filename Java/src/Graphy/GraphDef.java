package Graphy;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/6/8.
 */
class Graph{
    int v; //v代表多少个节点
    int e;//代表多少个边
    ListHead[] vetex;

    public Graph(int v, int e){
        this.v = v;
        this.e = e;
        vetex = new ListHead[v + 1];

        for (int i = 1; i <= v; i++){
            vetex[i] = new ListHead(i);//每个节点都是一个ListHead 链表结构
        }
    }

    public void addEdge(int a,int b){
        vetex[a].linkTo(b);
        vetex[b].linkTo(a);
    }

    //广度搜索
    public void breadthFirstSearch(){
        ArrayQueue<ListHead> q = new ArrayQueue<>(v);
        q.add(vetex[1]);//加入队列
        vetex[1].visited = true;//置为访问过
        while (!q.isEmpty()){
            ListHead tmp = q.remove(0);
            System.out.println(tmp.data);

            AdjacentListNode n = tmp.firstArc;

            while (n != null){
                tmp = vetex[n.nodeIndex];
                if (!tmp.visited){
                    q.add(tmp);
                    tmp.visited = true;
                }
                n = n.nextArc;
            }
        }
    }




}
class AdjacentListNode{
    public int nodeIndex;//每一个节点都有一个index
    public int info;//不知道
    public AdjacentListNode nextArc; //下一个
    public AdjacentListNode(int nodeIndex){
        this.nodeIndex = nodeIndex;
        nextArc = null;
    }
}

class ListHead{
    int data;//值
    AdjacentListNode firstArc; //头结点

    public boolean visited; //是否访问
    public ListHead(int data){
        this.data = data;
        visited = false;
    }
    public void linkTo(int end){
        if (firstArc == null){     //如果头结点是null则放入头结点
            firstArc = new AdjacentListNode(end);
            return;
        }
        AdjacentListNode n = firstArc; //得到头结点
        while (n.nextArc != null){  //找到下一个节点时null的
            n = n.nextArc;
        }
        n.nextArc = new AdjacentListNode(end);//则下一个节点为当前的值

    }

}



public class GraphDef {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int v = cin.nextInt();
        int e = cin.nextInt();
        Graph g = new Graph(v,e);

        for (int i = 0; i < e; i++){
            int a = cin.nextInt();
            int b = cin.nextInt();
            g.addEdge(a,b);
        }

        g.breadthFirstSearch();
    }
}
