package Super;

/**
 * Created by yinxin on 17-7-21.
 */
class Creature{
    public Creature(){
        System.out.println("Creature调用无参构造器");
    }
}
class  Animal extends Creature{
    public Animal(String name){
        System.out.println("Animal带一个参数构造器,"+"该动物name时"+name);
    }
    public Animal(String name ,int age){
        this(name);
        System.out.println("Animal带两个参数构造器,"+"其age时"+age);
    }
}
public class Wolf extends Animal{
    public Wolf()
    {
        //显式调用父类有两个参数的构造器
        super("灰太狼", 3);
        System.out.println("Wolf无参数的构造器");
    }
    public static void main(String[] args)
    {
        new Wolf();
    }
}
