package sumBinary;

/**
 * Created by 殷鑫 on 2017/4/3.
 */
public class F {
    public static void main(String args[]) {
        new F();
        int a = 2017;
        a = a << 30;
        System.out.println(a);
        a = a >> 30;
        System.out.println(a );
        //int a[] = new int[3];
        //F f= new F();
        System.gc();
    }
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method was called!");
    }
}