package deractor;

/**
 * Created by 殷鑫 on 2017/6/14.
 */
public class Water extends SecretRecipe {
    public Water(Food food){
        this.food = food;
    }
    @Override
    public void material() {
        food.material();
        System.out.println("水");
    }
}
