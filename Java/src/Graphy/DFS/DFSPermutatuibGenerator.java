package Graphy.DFS;

/**
 * Created by yinxin on 17-7-25.
 */
public class DFSPermutatuibGenerator {
    public int N;
    private boolean[] used;
    private int[] result;

    public DFSPermutatuibGenerator(int n){
        N = n;//3
        used = new boolean[n+1];// 1 2 3
        result = new int[n];//0 1 2
    }

    public static void main(String[] args) {
        DFSPermutatuibGenerator generator = new DFSPermutatuibGenerator(3);
        generator.make(0);
    }

    public void make(int level){
        for (int i = 1; i <= N; i++){
            if (!used[i]){
                used[i] = true;
                result[level] = i;
                make(level+1);
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
