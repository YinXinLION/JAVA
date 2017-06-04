package RPC1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 殷鑫 on 2017/6/4.
 */
public class Proxy1 implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Socket s = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;

            try {
                s = new Socket();
                s.connect(new InetSocketAddress("localhost", 8081));
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                oos.writeUTF("RPC1.ServiceImpl");
                oos.writeUTF(method.getName());
                oos.writeObject(method.getParameterTypes());
                oos.writeObject(args);

                return ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (s != null)
                    s.close();

                if (ois != null)
                    ois.close();

                if (oos != null)
                    oos.close();
            }
            return null;
        }
}
