/**
 * Created by 殷鑫 on 2017/5/10.
 */
public class TestLambda {
    public static void main(String[] args) {
        //匿名内部类的实现方式
        UserTest ut = new UserTest() {
            @Override
            public void test() {
                System.out.println("使用匿名内部类");
            }
        };
        ut.test();
        //() ：表示参数列表，不需要指定参数的类型，会自动判断
        // -> : 连接符
        //{} : 方法体
        UserTest userTest1 = ()->{
            System.out.println("使用Lambda表达式");
        };
        userTest1.test();
        //如果方法体只有一句，省略大括号和一个分号
        //如果有返回值，return也可省略
        UserTest userTest2 = ()-> System.out.println("最简化");
        userTest2.test();
        int i = 100;
        //一个参数可以省略圆括号
        UserTest1 userTest11 = t->{
            System.out.println("一个参数"+t);
        };
        userTest11.test(i);

        UserTest2 userTest21 = (t,x)->{
            System.out.println("两个参数"+ t +" "+x );
        };
        userTest21.test(i,i);

        UserTest3 userTest3 = x -> {
            x = x+10;
            return x;
        };
        int t = userTest3.test(15);
        System.out.println(t);
    }
}
//无参数无返回值
@FunctionalInterface
interface UserTest{
    void test();
}
//一个参数
@FunctionalInterface
interface UserTest1{
    void test(int i);
}
//两个参数
@FunctionalInterface
interface UserTest2{
    void test(int i, int j);
}
//一个参数，有返回值
@FunctionalInterface
interface UserTest3{
    int test(int i);
}