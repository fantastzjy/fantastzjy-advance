package juc.创建线程;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 *  Callable+ThreadPoolExecutor示例代码
 */
public class ThreadPoolExecutor_Callable {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY), //不用指定类型  也不能指定类型
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new MyCallable();

        for (int i = 0; i < 10; i++) {

            //返回值类型不是Future接口类
            //pool.submit(callable);的returns为  a Future representing pending completion of the task
            //FutureTask<String> submitRes = pool.submit(callable);
            Future<String> submitRes = pool.submit(callable);
            //System.out.println("111111"+submitRes.get());
            list.add(submitRes);
        }
        for (Future<String> fut : list) {
            try {
                System.err.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        pool.shutdown();
    }

}


class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}