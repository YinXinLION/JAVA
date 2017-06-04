package RPC1;

import java.lang.reflect.Proxy;

/**
 * Created by 殷鑫 on 2017/6/4.
 */
public class Client {

        public static void main(String args[]) {
            Service echo = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(),
                    new Class<?>[]{Service.class}, new Proxy1());

            for (int i = 0; i < 3; i++) {
                System.out.println(echo.echo(String.valueOf(i)));
            }
        }
}
