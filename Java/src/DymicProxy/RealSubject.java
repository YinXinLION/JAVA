package DymicProxy;

/**
 * Created by 殷鑫 on 2017/6/1.
 */
public class RealSubject implements Subject {
    @Override
    public void request(int id) {
        System.out.println(id);
    }
}
