package 回调机制;

/**
 * Created by yinxin on 17-8-19.
 */
public class Student {
    private String name = null;

    public Student(String name)
    {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private int calcADD(int a, int b)
    {
        return a + b;
    }

    public void fillBlank(int a, int b)
    {
        int result = calcADD(a, b);
        System.out.println(name + "心算:" + a + " + " + b + " = " + result);
    }
}
