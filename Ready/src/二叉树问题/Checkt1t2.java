package 二叉树问题;

/**
 * Created by yinxin on 17-8-30.
 */
public class Checkt1t2 {
    public boolean contains(Node t1, Node t2){
        return check(t1,t2) || contains(t1.left, t2) || contains(t1.right , t2);
    }
    //查看h 和 t2 是否是相同的
    public boolean check(Node h, Node t2){
        if (t2 == null){  //如果t2 为null 了 表示搜索正确
            return true;
        }
        if (h == null || h.value != t2.value){ //如果h是 null 但t2不是null 返回false
            return false;                       //如果h.value和t2.value不是null 返回false
        }
        return check(h.left,t2.left) && check(h.right, t2.right); //递归查看
    }
}
