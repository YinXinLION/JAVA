package 栈和队列;

import java.util.Stack;

/**
 * Created by yinxin on 17-8-26.
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) throws Exception {
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() throws Exception {
        if (this.stackData.isEmpty()){
            throw new Exception();
        }
        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }
    public int getMin() throws Exception {
        if (this.stackMin.isEmpty()){
            throw new Exception();
        }
        return this.stackMin.peek();
    }
}
