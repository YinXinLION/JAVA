package tenth;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by 殷鑫 on 2017/2/5.
 */
//completionservice用于提交一组callable任务，take方法返回已完成callable任务对应的future对象

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newSingleThreadExecutor();

        Future<String> future = threadpool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Hello";
            }
        });
        System.out.println("等到结果");
        System.out.println(future.get());

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService(executorService);
        for (int i = 1; i <= 10; i++){
            final int task = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return task;
                }
            });
        }
        for (int i = 1; i <= 10; i++){
            System.out.println(completionService.take().get());

        }

    }
}
