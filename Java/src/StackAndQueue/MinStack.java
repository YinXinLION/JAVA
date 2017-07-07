package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yinxin on 17-7-8.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Map<Integer,Integer> minMap;
    public MinStack(){
        this.stack = new Stack<Integer>();
        this.minMap = new HashMap<Integer,Integer>();
    }
    public void push(int x){
        if (stack.isEmpty()){
            stack.push(x);
            minMap.put(stack.size(),x);
        }else{
            int preMin = minMap.get(stack.size());
            stack.push(x);
            minMap.put(stack.size(), Math.min(preMin,x));
        }
    }
    public static void main(String[] args) {

    }
    public void pop(){
        stack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minMap.get(stack.size());
    }
}
