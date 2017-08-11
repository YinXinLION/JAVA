package braclets;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yinxin on 17-8-10.
 */
public class StackDemo {


    public static void main(String[] args) {
        String str = "(()()()())";
        char[] c = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++){
            char w = c[i];
            if (w == '('){
                stack.push(w);
            }
            if (w == ')'){
                char a = stack.peek();
                if (a == '('){
                    stack.pop();
                }
                if (a == ')'){
                    break;
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
