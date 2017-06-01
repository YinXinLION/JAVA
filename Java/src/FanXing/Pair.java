package FanXing;

/**
 * Created by 殷鑫 on 2017/5/11.
 */
public class Pair<T> {
    T first;
    T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
