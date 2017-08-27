package 栈和队列;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-26.
 */
//用一个栈实现另一个栈的排序
public class SortStackbyStack {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){//如果栈没空执行
            int cur = stack.pop();//得到栈顶
            //如果help是null直接放入
            //如果不是null,cur小于等于压入help
            //如果cur大于则help全部压入
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
