package sumBinary;

/**
 * Created by 殷鑫 on 2017/3/16.
 */
public class test2 {
    public static void main(String[] args) {

        int n = 3;
        int[] array = new int[n+1];
        for (int i = 0; i <= n; i++){
            array[i] = i;
         }
        for (int i = 1; i <= n;i++){
            int index = i;
            for (int j = 1; j <= n ;){
                int w = j;
                while (w <= j){
                    System.out.print(array[w]);
                    w++;
                }
                System.out.println();
                j = w;
            }
        }
    }
}
