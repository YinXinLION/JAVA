package 栈和队列;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-26.
 */
//1.如果stackPop不为空，stackPush不能压入 2.必须一次性压入stackPop
public class TowStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TowStacksQueue(){
        stackPop = new Stack<>();
        stackPush = new Stack<>();
    }
    public void add(int pushInt){
        stackPush.push(pushInt);
    }
    public int poll() throws Exception {
        if (stackPop.empty() && stackPush.empty()){
            throw new Exception();
        }else if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() throws Exception {
        if (stackPop.empty() && stackPush.empty()){
            throw new Exception();
        }else if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
