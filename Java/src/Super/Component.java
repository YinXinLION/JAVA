package Super;

/**
 * Created by yinxin on 17-7-21.
 */
//子类不会获得父类构造器，但子类构造器可以调用父类构造器初始化代码
public class Component {
    private String name;
    private int age;
    public Component(String name){
        this.name = name;
    }
    public Component(String name,int age){
        this(name);//在一个构造器中调用另一个重载的构造器，使用this调用来完成，
        this.age = age;
    }
}
