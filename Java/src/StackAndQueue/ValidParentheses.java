package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yinxin on 17-7-7.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid(""));
    }

    public static boolean isValid(String s){
        if (s.equalsIgnoreCase("")) return true;
        Map<Character,Character> ps = new HashMap<Character,Character>();
        ps.put('{','}');ps.put('[',']');ps.put('(',')');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (ps.containsKey(c)){ //如果c是括号，放入栈
                stack.push(c);
            }else { //如果c不是括号
                if (stack.isEmpty()){ //如果栈为null，则意思是没有右括号，无效
                    return false;
                }else {
                    Character top = stack.peek();//取出栈顶
                    if (ps.get(top).equals(c)){ //查看是否有对应的
                        stack.pop();
                    }else {
                        return false;//否则错误
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
