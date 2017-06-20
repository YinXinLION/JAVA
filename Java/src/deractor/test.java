package deractor;

/**
 * Created by 殷鑫 on 2017/6/14.
 */
public class test {
    public static void main(String[] args) {
        Bread bread = new Bread();
        Water water =   new Water(bread);
        water.material();
    }
}
