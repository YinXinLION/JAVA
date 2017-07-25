package In;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

/**
 * Created by yinxin on 17-7-25.
 */
public class Outer2 {
    private int a = 100;
    public  void test(final int param){
        final String str = "hello";
        class Inner{  //方法内部类之内定义在外部类方法中，可以访问外部实例，静态 还可以访问final方法参数
            public void innerMethod(){
                System.out.println("outer a" + a);
                System.out.println("param " + param);
                System.out.println("local var " + str);

            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        new Outer2().test(100);
    }
}
