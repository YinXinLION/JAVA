package ClassLoaderTest.Hotdeploy;

import ClassLoaderTest.Celue.Hello;
import ClassLoaderTest.ClassLoaderDemo;

import java.io.File;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class HotDeployDemo {
    private static final String CLASS_NAME = "ClassLoaderTest.Hotdeploy.HelloService";
    private static final String FILE_NAME = "E:/Git/JAVA/Java/out/production/Java/"
            +CLASS_NAME.replaceAll("\\.", "/")+".class";
    private static volatile HelloService helloService;

    public static HelloService getHelloService(){
        if (helloService != null){
            return helloService;
        }
        synchronized (HotDeployDemo.class){
            if (helloService == null){
                helloService = createService();
            }
            return helloService;
        }
    }

    private static HelloService createService(){
        try {
            MyClassLoader myClassLoader = new MyClassLoader();
            Class<?> cls = myClassLoader.loadClass(CLASS_NAME);
            if (cls != null){

                return (HelloService)cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void client() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        HelloService helloService = getHelloService();
                        helloService.action();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }
    public static void monitor() {
        Thread t = new Thread() {
            private long lastModified = new File(FILE_NAME).lastModified();

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(100);
                        long now = new File(FILE_NAME).lastModified();
                        if (now != lastModified) { //检查是否更新
                            lastModified = now;
                            reloadHelloService();//重新加载
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }

    public static void reloadHelloService() {
        helloService = createService();//重新实例化
    }

    public static void main(String[] args) {
        monitor();
        client();
    }
}
