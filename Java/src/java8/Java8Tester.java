package java8;



import java.util.*;

/**
 * Created by yinxin on 17-7-24.
 */
public class Java8Tester {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Tester tester = new Java8Tester();
        System.out.println("使用Java7语法：");

        tester.sortUsingJava7(names1);
        System.out.println(names1);

        System.out.println("使用 JAVA8 语法：");

        tester.sortUsingJava8(names2);
        System.out.println(names2);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
    //java7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
    //java8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names,(s1,s2)->s1.compareTo(s2));
    }
}
