/**
 * Created by yinxin on 17-9-3.
 */
public class 全排列 {
    public int N;
    private boolean[] used;
    private int[] result;

    全排列(int n ){
        N = n;
        used = new boolean[n+1];
        result = new int[n];
    }
    public static void main(String[] args) {
        全排列 gen = new 全排列(4);
        gen.make(0);
    }
    public void make(int level){
        for (int i = 1; i <= N; i++){
            if (!used[i]){
                used[i] = true;
                result[level] = i;
                make(level + 1);
                used[i] = false;
            }
        }
        if (level == N-1){
            for (int i = 0; i < N; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
