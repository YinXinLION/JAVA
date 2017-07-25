package In;

/**
 * Created by yinxin on 17-7-25.
 */
public class Outer1 {
    private static int i = 100;
    private int t = 100;
    public class inner{
        public void hello(){
            System.out.println("hello");
            Outer1.this.t();
            System.out.println(i + " " + t);
        }
    }
    public  void t(){

        System.out.println("t");
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        inner in = outer1.new inner();//外部类new后再new内部类。 先创建一个Outer1对象
        in.hello();
    }
}
