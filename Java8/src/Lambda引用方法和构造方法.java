import javax.jws.soap.SOAPBinding;

/**
 * Created by 殷鑫 on 2017/5/10.
 */
public class Lambda引用方法和构造方法 {
    public static void main(String[] args) {
        TestClassMethodRef ref = (s) -> {
            Lambda引用方法和构造方法.output(s);
        };
        ref.test("asb");
        //引用类方法; <类名>::<类方法>,会自动把参数传递给类方法
        TestClassMethodRef ref1 =  Lambda引用方法和构造方法::output;
        ref1.test("asd");

        TestClassMethodRef1 ref2 = Lambda引用方法和构造方法::output2;
        ref2.test("12","23");

        //实例方法引用，必须通过实例来引用
        //<实例>::<实例方法>
        TestClassMethodRef ref3 = System.out::print;
        ref3.test("LION");

        TestClassMethodRef ref4 = ref::test;
        ref4.test("hello");
        //引用构造器
        TestClassMethodRef2 ref5 = ()->{
            return new User();
        };
        User user = ref5.getUser();

        TestClassMethodRef2 ref6 = User::new;
        User user1 = ref6.getUser();

        //匿名内部类
        TestClassMethodRef2 ref21 = new TestClassMethodRef2() {
            @Override
            public User getUser() {
                System.out.println("匿名内部类");
                return new User();
            }
        };

        //通过类访问实例方法
        //函数式接口方法的参数中，第一个参数必须是::前面的类名的一个实例
        TestClassMethodRef3 ref31= TestClassMethodRef2::getUser;
        System.out.println(ref31.getUser(ref21) + "   asd");
    }
    //类方法
    public static void output(String str){
        System.out.println("类方法输出"+str);
    }
    public static void output2(String str,String str1){
        System.out.println("类方法输出"+str + "," + str1);
    }
}

@FunctionalInterface
interface TestClassMethodRef{
    void test(String str);
}
@FunctionalInterface
interface TestClassMethodRef1{
    void test(String str,String str1);
}
@FunctionalInterface
interface TestClassMethodRef2{
    User getUser();
}

interface TestClassMethodRef3{
    User getUser(TestClassMethodRef2 ref2);
}
class User{
    User(){
        System.out.println("User的构造方法被执行。");
    }
}

