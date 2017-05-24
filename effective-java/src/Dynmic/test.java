package Dynmic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 殷鑫 on 2017/5/16.
 */
public class test {

    public static void main(String[] args) {
        Map<String,List<String>> anagrams = newHashMap();
    }

    public static <K,V> HashMap<K,V> newHashMap(){
        return new HashMap<K, V>();
    }
    private Class<?>  hello(Class<?> t) throws IllegalAccessException, InstantiationException {
        return (Class<?>) t.newInstance();
    }
}
