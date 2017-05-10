package Trie;

import com.sun.xml.internal.ws.util.StringUtils;
import sun.text.normalizer.Trie;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 殷鑫 on 2017/3/10.
 */
//字典树节点
class TrieNode{
    //true关键词结束
    private boolean end = false;
    //key子节点的值，value 对应节点的值
    private Map<Character,TrieNode> subNodes = new HashMap<Character,TrieNode>();
    //添加子节点
    void addSubNode(Character key,TrieNode trieNode){
        subNodes.put(key,trieNode);
    }
    //获取下一个节点
    TrieNode getSubNode(Character key){
        return subNodes.get(key);
    }
    //判断是否是敏感词终点
    boolean isKeyWordEnd(){
        return end;
    }
    //设置敏感词终点
    void setKeyWordEnd(boolean end){
        this.end = end;
    }
    //获取此节点个数
    public int getSubNodeCount(){
        return subNodes.size();
    }
}
public class Test {
    private TrieNode rootNode = new TrieNode();
    public static void main(String[] args) {

    }


    //添加到树上
    private void addWord(String txt){
        TrieNode tempNode = rootNode;
        for (int i = 0; i < txt.length();i++){
            Character c = txt.charAt(i);

            TrieNode node = tempNode.getSubNode(c);
            if (node == null){
                tempNode.addSubNode(c,new TrieNode());
            }
            tempNode = node;
            if (i == txt.length() - 1){
                tempNode.setKeyWordEnd(true);
            }
        }
    }
    //开始过滤
    public String filter(String text){
        return "";
    }
}
