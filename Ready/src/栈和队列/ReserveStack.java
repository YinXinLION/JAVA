package 栈和队列;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-26.
 */

public class ReserveStack {
    //将栈stack的栈底元素返回并删除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    //逆序一个栈
    public static void reserve(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reserve(stack);
        stack.push(i);
    }
}
