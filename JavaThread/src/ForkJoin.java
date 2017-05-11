import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by 殷鑫 on 2017/5/11.
 */
//ForkJoin子类
    //RecursiveAction 返回没结果的任务
    //RecursiveTask 返回有结果的任务
public class ForkJoin extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 2; //阈值
    private int start;
    private int end;

    public ForkJoin(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算呢

        boolean canCpmpute =  (end - start) <= THRESHOLD;
        if (canCpmpute){
            for (int i = start; i <= end;i++){
                sum += i;
            }
        }else {
            //如果任务大于阈值，分裂成2个子任务
            int middle = (start + end) / 2;
            ForkJoin leftTask  = new ForkJoin(start,middle);
            ForkJoin rightTask  = new ForkJoin(middle,end);
            //执行任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务完
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务 1+2+3+4
        ForkJoin task = new ForkJoin(1,4);
        Future<Integer> future = forkJoinPool.submit(task);
        System.out.println(future.get());
    }
}
