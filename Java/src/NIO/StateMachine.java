package NIO;

/**
 * Created by yinxin on 17-7-8.
 */
//实现一个状态机
public class StateMachine {
    static int state = 0;
    public static void main(String[] args) {
        String s = "I have a good news :\"hello world\"";
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (state == 0){
                if (s.charAt(i) < 'z' && s.charAt(i) > 'A'){
                    state = 1; //继续读状态
                }else if (s.charAt(i) == '\\'){
                    state = 2;
                }else {
                    state = 1;
                }
            }
            if (state == 1){
                if (s.charAt(i) < 'z' && s.charAt(i) > 'A'){
                    sb.append(s.charAt(i));
                    state = 1;
                }else if (s.charAt(i) == ' '){
                    state = 0;
                    sb.append(" ,");
                }else {
                    state = 2;

                }
            }
            if (state == 2){
                if (s.charAt(i) == '"'){
                    sb.append(" ,");
                    sb.append(s.charAt(i));
                    sb.append(" ");
                    state = 0;
                }else {
                    sb.append(s.charAt(i));
                    state = 0;
                }
            }
        }
        System.out.println(sb);
    }
}
