package 回调机制;

/**
 * Created by yinxin on 17-8-19.
 */
public class Test
{
    public static void main(String[] args)
    {
        int a = 1;
        int b = 1;
        Student s = new Student("小明");
        s.fillBlank(a, b);
    }
}
