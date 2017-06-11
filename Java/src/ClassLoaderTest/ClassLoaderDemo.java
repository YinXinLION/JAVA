package ClassLoaderTest;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();//获取加载ClassLodaerDemo的classLoader
        while (cl != null){
            System.out.println(cl.getClass().getName());//得到名字
            cl = cl.getParent();//获取委派的父类
        }
        System.out.println(String.class.getClassLoader());
    }
}
