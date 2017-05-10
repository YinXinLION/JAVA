package Skip;

import java.util.Random;

/**
 * Created by 殷鑫 on 2017/3/13.
 */
public class SkipList {
    private SkipListNode head,tail;
    private int nodes; //节点总数
    private int listLevel;//层数
    private Random random; //用于投掷硬币
    private static final double PROBABILITY = 0.5;//向上提升一个的概率
    public SkipList(){
        random = new Random();
        clear();
    }
    public void clear(){
        head = new SkipListNode(SkipListNode.HEAD_KEY,0);
        tail = new SkipListNode(SkipListNode.TAIL_KEY,0);
        horizontalLink(head,tail);
        listLevel = 0;
        nodes = 0;

    }
    //判断跳跃表是否为空
    public boolean isEmpty(){
        return  nodes == 0;
    }
    //返回节点数
    public int size(){
        return nodes;
    }
    //查找是否存储key
    public SkipListNode findNode(int key){
        SkipListNode p = head;
        //从头开始，如果右边的不是尾节点，并且比查找的数小，那么一直向右移动，
        //当右边的数比key大，那么查看是否可以向下移动，如果为空，那么未查找到，如果不是空
        //那么向下移动，并且继续循环向右移
        while (true){
            while (p.right.key!=SkipListNode.TAIL_KEY&&p.right.key<=key){
                p = p.right;
            }
            if (p.down != null){
                p = p.down;
            }else {
                break;
            }
        }
        return p;
    }
    //查找是否存储key，存在则返回该节点，否则返回null
    public SkipListNode search(int key){
        SkipListNode p = findNode(key);
        if (key == p.getKey()){
            return p;
        }else {
            return null;
        }
    }
    //进行水平双向连接连接
    public void horizontalLink(SkipListNode node1, SkipListNode node2){
        node1.right = node2;
        node2.left = node1;
    }
    //垂直双向连接
    public void vertiacallLink(SkipListNode node1, SkipListNode node2){
        node1.down = node2;
        node2.up = node1;
    }

    //向跳跃表中添加key value
    public void put(int key,int value){
        SkipListNode p = findNode(key);
        //如果相同替换原来的
        if (key == p.getKey()){
            p.value = value;
            return;
        }
        SkipListNode q = new SkipListNode(key,value);
        backLink(p,q);//q插入到p后边
        int currentLevel = 0; //所在层级为0
        //抛硬币决定是否增加层级
        while (random.nextDouble() < PROBABILITY){
            //如过超出高度那么要重新建一个顶层
            if (currentLevel >= listLevel){
                listLevel++;//最高层++
                //创建一个头一个尾
                SkipListNode p1 = new SkipListNode(SkipListNode.HEAD_KEY,0);
                SkipListNode p2 = new SkipListNode(SkipListNode.TAIL_KEY,0);
                horizontalLink(p1,p2);//左右连接
                vertiacallLink(p1,head);//上下连接
                vertiacallLink(p2,tail);//上下连接
                head = p1;
                tail = p2;
            }
            //将p移动到上层
            while (p.up == null){
                p = p.left;
            }
            p=p.up;//向上移动到第二层 直接向后面插入即可，这个节点小于即将插入的节点
            SkipListNode e = new SkipListNode(key,0);//只保存key 要插入的节点
            backLink(p,e);//左右插
            vertiacallLink(e,q); //e和q上下连接 2个值相同的节点
            q = e;//将q向上移动 防止硬币为正 进行第三次插入
            currentLevel++;
        }
        nodes++;
    }

    //node1 后面插入 node2
    private void backLink(SkipListNode node1,SkipListNode node2){
        node2.left = node1;
        node2.right = node1.right;
        node1.right.left = node2;
        node1.right = node2;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SkipList list=new SkipList();
        System.out.println(list);
        list.put(2, 1);
        list.put(1, 1);
        list.put(3, 1);
        list.put(1, 1);//测试同一个key值
        list.put(4, 1);
        list.put(6, 1);
        list.put(5, 1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.listLevel);
        System.out.println(list.search(1));
    }
}
