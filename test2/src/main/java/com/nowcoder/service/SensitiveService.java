package com.nowcoder.service;

import com.nowcoder.controller.QuestionController;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.propertyeditors.InputSourceEditor;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 殷鑫 on 2017/1/31.
 */
//敏感词查找与替换
@Service
public class SensitiveService implements InitializingBean{
    private static final Logger logger = LoggerFactory.getLogger(SensitiveService.class);
    //读取过滤词
    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("SensitiveWords.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = bufferedReader.readLine()) != null){
                addWord(s.trim());
            }
            bufferedReader.close();
        }catch (Exception e){
            logger.error("读取敏感词失败"+e.getMessage());
        }
    }
    //添加到树上
    private void addWord(String txt){
        TrieNode tempNode = rootNode;
        for (int i = 0; i < txt.length();i++){
            Character c = txt.charAt(i);
            if(isSymbol(c)){
                continue;        // -> 你 好 == 你好
            }
            TrieNode node = tempNode.getSubNode(c);
            if (node == null){
                node = new TrieNode();
                tempNode.addSubNode(c,node);
            }
            tempNode = node;
            if (i == txt.length() -1){
                tempNode.setKeywordEnd(true);
            }
        }
    }

    //字典树
    private class TrieNode{
        //true关键词结束
        private boolean end = false;
        //key 子节点的值， TrieNode 对应的节点
        private Map<Character ,TrieNode> subNodes = new HashMap<Character,TrieNode>();
        //添加子节点
        void addSubNode(Character key, TrieNode node){
            subNodes.put(key,node);
        }
        //获取下个节点
        TrieNode getSubNode(Character key){
            return subNodes.get(key);
        }
        //判断是否是敏感词的终点
        boolean isKeywordEnd(){
            return end;
        }
        //设置终点
        void setKeywordEnd(boolean end){
            this.end = end;
        }
        public int getSubNodeCount(){
            return subNodes.size();
        }
    }

    private TrieNode rootNode = new TrieNode();

    //是否是正常文字
    private boolean isSymbol(char c){
        int ic = (int)c;
        //东亚文字 0x2E80-0x9FFF
        return !CharUtils.isAsciiAlphanumeric(c) && (ic < 0x2E80 || ic > 0x9FFF);
    }
    
    public String filter(String text){
        if (StringUtils.isBlank(text)){
            return text;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String replacement="***";
        TrieNode tempNode = rootNode;
        int begin = 0;
        int position = 0;
        while (position < text.length()){
            char c = text.charAt(position);

            if (isSymbol(c)){
                if (tempNode == rootNode){
                    stringBuilder.append(c);
                    begin++;
                }
                position++;
                continue;
            }
            tempNode = tempNode.getSubNode(c);
            if (tempNode == null){
                stringBuilder.append(text.charAt(begin));
                position = begin + 1;
                begin = position;
                tempNode = rootNode;
            }else if (tempNode.isKeywordEnd()){
                //如果是敏感词
                stringBuilder.append(replacement);
                position = position + 1;
                begin = position;
                tempNode = rootNode;
            }else {
                position++;
            }
        }
        return stringBuilder.toString();
    }

//    public static void main(String[] args) {
//        SensitiveService s = new SensitiveService();
//        s.addWord("色情");
//        s.addWord("赌博");
//        System.out.println(s.filter("赌博色         情"));
//    }

}
