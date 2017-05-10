package Jinritoutiao;

/**
 * Created by 殷鑫 on 2017/4/18.
 */
public class renwuzhixingcelue {
    public static void main(String[] args) {
        int tasks = 2;
        int time = 10;
        //-1为占位符
        int cost[] = {-1,1,4};
        int value[] = {-1,10,6};
        int deadline[] = {-1,5,4};
        int maxvalue = 0;

        int[][] tmp = new  int[tasks+1][time+1];

        int task = 1;
        for(;task<=tasks;task++){
            int t;
            for(t=1;t<=time;t++){
                if(t>deadline[task])
                    continue;
                if(t>=cost[task]){
                    tmp[task][t] = tmp[task-1][t];
                    if((tmp[task-1][t-cost[task]+1] + value[task])> tmp[task][t])
                        tmp[task][t] = tmp[task-1][t-cost[task]+1] + value[task];
                    System.out.printf("%d %d = %d n", task, t, tmp[task][t]);
                    maxvalue = maxvalue<tmp[task][t]? tmp[task][t]:maxvalue;
                }
            }
        }

        System.out.printf("max = %d n", maxvalue);
    }
}
