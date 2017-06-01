package FanXing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/5/11.
 */
//使用Pair了解传递类型参数
public class test1 {
    public static void main(String[] args) {
        Pair<Integer> minmax = new Pair<Integer>(1,100);
        Integer min = minmax.getFirst();
        Integer max = minmax.getSecond();
        System.out.println(min + " " + max);

        Pair<String> kv = new Pair<String>("name","狮子");


        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings,new Integer(42));
    }
    private static void unsafeAdd(List list,Object o){
        list.add(o);
    }
}
