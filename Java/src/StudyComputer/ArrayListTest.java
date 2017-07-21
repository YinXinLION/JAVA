package StudyComputer;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by yinxin on 17-7-21.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();

        //添加
        intList.add(123);
        intList.add(456);
        intList.add(789);

        for (Integer a : intList){
//            intList.remove(a); 
            System.out.println(a);
        }

        for (int i = 0; i < intList.size(); i++){
            if (intList.get(i) == 123){
                intList.remove(i);
            }
            System.out.println(intList.get(i));
        }

        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
