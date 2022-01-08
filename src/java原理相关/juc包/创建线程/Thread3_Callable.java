package java原理相关.juc包.创建线程;

import java.util.concurrent.*;

/**
 callable 接口创建的线程 不能直接启动  要加一个  FutureTask
 *
 */
public class Thread3_Callable implements Callable<String> {
    private String string;

    public Thread3_Callable(String string) {
        this.string = string;
    }

    @Override
    public String call() {
        System.out.println("通过实现 Callable<T> 接口");
        return "Callable返回值" + string;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //ExecutorService pool = Executors.newFixedThreadPool(1);
        //Future<String> task = pool.submit(new Thread3_Callable("线程1"));
        //这里要要抛出异常
        //String s = task.get();
        //pool.shutdown();

        System.out.println("--------------实现FutureTask方式创建------------------------");
        Thread3_Callable callable = new Thread3_Callable("FutureTask");
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //Future<String> future = new FutureTask<>(callable);
        // new Thread() 必须传的是futuretask才行  futrue不可
        //因为  futureTask  实现了 Runnable接口
        //如果是线程池可以直接提交callable  不用futuretask封装  且返回的必须是future类（如果提交的是callablle）
        new Thread(futureTask).start();

        //获取返回值 调用futureTask.get()  只会执行一遍线程
        // 如果想要领个结果需要创建一个新得futuretask线程
        //System.out.println(futureTask.get());
        System.out.println(futureTask.get());

    }

}
