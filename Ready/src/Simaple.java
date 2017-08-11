/**
 * Created by yinxin on 17-8-10.
 */
//公鸡一个五块钱，母鸡一个三块钱，小鸡三个一块钱，现在要用一百块钱买一百只鸡，问公鸡、母鸡、小鸡各多少只？
public class Simaple {
    public static void main(String[] args) {
        int i,j,k;
        for (i = 0; i <= 20; i++){
            for (j = 0 ; j <= 33;j++){
                for (k= 0; k <= 99; k=k+3){
                    if (5*i+3*j+k/3==100 && k%3==0 && i+j+k==100 ){
                        System.out.printf("公鸡 %2d 只，母鸡 %2d 只，小鸡 %2d 只\n", i, j, k);
                    }
                }
            }
        }
    }
}
