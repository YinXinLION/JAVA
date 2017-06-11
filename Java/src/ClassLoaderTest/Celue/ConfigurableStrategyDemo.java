package ClassLoaderTest.Celue;

import ClassLoaderTest.ClassLoaderDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class ConfigurableStrategyDemo {
    public static IService creaeteService(){
        try {
            Properties prop = new Properties();
            String fileName = "E:\\Git\\JAVA\\Java\\src\\ClassLoaderTest\\Celue\\config.properties";
            prop.load(new FileInputStream(fileName));
            String className = prop.getProperty("service");
//            System.out.println(className);
            Class<?> cls = Class.forName(className);
            return (IService)cls.newInstance();
        } catch (Exception e) {
            throw  new  RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        IService service = creaeteService();
        service.action();
    }
}
