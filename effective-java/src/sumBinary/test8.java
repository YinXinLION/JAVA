package sumBinary;

import Trie.Test;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 殷鑫 on 2017/4/6.
 */
public class test8 {
    private static List<Test> list = new ArrayList<Test>();
    public static void main(String[] args) throws InterruptedException{
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
// get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        for (int i = 0; i < 10000; i++){
            Test test = new Test();
            list.add(test);
            Thread.sleep(50);
        }
    }
}
