package ClassLoaderTest;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class ClassLoaderDemo3 {
    public static class Hello{
        static {
            System.out.println("hello");
        }
    };
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String className = ClassLoaderDemo3.class.getName()+"$Hello";
        try {
//            Class<?> cls = cl.loadClass(className);
            Class<?> cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
