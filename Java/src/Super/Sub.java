package Super;

/**
 * Created by yinxin on 17-7-21.
 */
/*
    在子类构造器中调用父类构造器使用super调用来完成
*/

public class Sub extends Base{
   public String color;
   public Sub(double size, String name, String color){
       //通过super调用来调用父类构造器的初始化过程
       super(size,name);//只能在第一行
       this.color = color;
   }

    public static void main(String[] args) {
        Sub s = new Sub(5.6,"测试对象", "红色");
        System.out.println(s.size+ s.color+ s.name);
    }
}

class Base{
    public double size;
    public String name;
    public Base(double size, String name){
        this.size = size;
        this.name = name;
    }
}
