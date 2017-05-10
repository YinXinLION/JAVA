package Skip;

/**
 * Created by 殷鑫 on 2017/3/13.
 */
public class SkipListNode {
    public int key;
    public int value;
    public SkipListNode up,down,left,right;//每个节点都是上下4个指针
    public static final int HEAD_KEY = Integer.MAX_VALUE;
    public static final int TAIL_KEY = Integer.MIN_VALUE;
    public SkipListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int getKey(){
        return key;
    }
    public int getValue(){
        return value;
    }
    public void setKey(int key){
        this.key = key;
    }
    public void setValue(int value){
        this.value = value;
    }

    public String toString(){
        return "key-value:" + key + "-"+ value;
    }

}
