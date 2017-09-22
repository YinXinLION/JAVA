package 小米;

import java.util.*;
public class test2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        while(in.hasNext()){
            String s = in.next();
            if (s.equals("-")) {
                break;
            }
            int id = in.nextInt();
            list.add(s);
            list1.add(id);
        }
        while(in.hasNext()){
            String s = in.next();
            int pos = -1;
            int length = 0;
            for (String t : list){
                if(s.startsWith(t) && (s.length() == t.length() || s.charAt(t.length()) == '/')){
                    if(t.length() > length) {
                        length = t.length();
                        pos = list.indexOf(t);
                    }
                }
            }
            if (pos != -1) {
                System.out.println(list1.get(pos));
            }else {
                System.out.println(0);
            }
        }
    }
}