package sumBinary;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 殷鑫 on 2017/4/3.
 */
public class test7 {

    //AtomicReference 引用
    static class Pair {
        final private int first;
        final private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public static void main(String[] args) {
        Pair p = new Pair(100, 200);
        AtomicReference<Pair> pairRef = new AtomicReference<>(p);
        pairRef.compareAndSet(p, new Pair(200, 200));
        System.out.println(pairRef.get().getFirst());
    }
}
