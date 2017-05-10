import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 殷鑫 on 2017/4/22.
 */
public class eluositaowa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] envelopes = new int[num][2];
        int i = 0;
        while (i < num){
            envelopes[i][0] = scanner.nextInt();
            envelopes[i][1] = scanner.nextInt();
            i++;
        }
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        //构造比较器，按照宽度排序（按照高度也可以，保证前一个无法装后一个即可）
        Comparator<int[]> c=new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                return e1[0]-e2[0];
            }
        };
        Arrays.sort(envelopes, c);
        int max=0;
        int[] res=new int[envelopes.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]) {
                    res[i]=Math.max(res[i], 1+res[j]);
                }
            }
            max=Math.max(max, res[i]);
        }
        return max;
    }
}
