package DymicProxy;

/**
 * Created by 殷鑫 on 2017/6/1.
 */
public class Client {
    public static void main(String[] args) {
        dynamicProxy();
    }
    public static void dynamicProxy(){
        Subject realSubject = new RealSubject();
        Subject proxy = (Subject)java.lang.reflect.Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), new InvocationSubject(realSubject));
        proxy.request(1);
    }
}
