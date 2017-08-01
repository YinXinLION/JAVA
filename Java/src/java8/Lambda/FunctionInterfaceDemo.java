package java8.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yinxin on 17-8-1.
 */
//判断这个人是否是成人
public class FunctionInterfaceDemo {
    @FunctionalInterface
    interface Predicate<T>{
        boolean test(T t);
    }

    public static boolean doPredicate(int age, Predicate<Integer> predicate){
        return predicate.test(age);
    }


    public static List<String> filter(List<String> fruit, Predicate<String> predicate){
        List<String> f = new ArrayList<>();
        for (String s : fruit) {
            if(predicate.test(s)){
                f.add(s);
            }
        }
        return f;
    }

    public static void main(String[] args) {
        boolean isAdult = doPredicate(20, x -> x >= 18);
        System.out.println(isAdult);

        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, (f) -> f.length() == 2);
        System.out.println(newFruit);
    }
}
