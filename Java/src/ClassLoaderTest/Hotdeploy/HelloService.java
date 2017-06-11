package ClassLoaderTest.Hotdeploy;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class HelloService implements IService {
    @Override
    public void action() {
        System.out.println("Hello");
    }
}
