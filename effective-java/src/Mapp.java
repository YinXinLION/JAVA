import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by 殷鑫 on 2017/4/8.
 */
public class Mapp {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(6,6);
        map.put(2,2);
        map.put(4,4);
        map.put(3,3);
        map.put(5,5);
        System.out.println(map);
        LinkedHashMap t = new LinkedHashMap();
        t.put(10,10);
        t.put(7,7);
        t.put(13,13);
        t.put(9,9);
        System.out.println(t);

    }
}
