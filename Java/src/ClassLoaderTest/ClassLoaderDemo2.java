package ClassLoaderTest;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class ClassLoaderDemo2 {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        try {
            Class<?> cls = cl.loadClass("java.util.ArrayList"); //不一定调用loadClass的ClassLoader
            ClassLoader actualLoader = cls.getClassLoader();//由BootStrap ClassLoader加载
            System.out.println(actualLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
