package Java原理相关.juc包.ThreadPool线程池;

import java.util.concurrent.*;

public class LearnThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException {

        //CPU密集型,设置最大线程数为：CPU核数
        Runtime.getRuntime().availableProcessors();
        //IO密集型，根据io任务的线程数来规定最大线程数量

        //核心线程数
        //最大线程数
                    //线程池的伸缩性，达到开启条件后，才会不断开启
                    //开启条件：
                    //当阻塞队列是ArrayBlockingQueue的时候，核心线程全部都处于工作状态，且阻塞队列已经被任务塞满了，
                    //那么再来新的任务请求，便会开启新的线程,同时执行的线程数为最大线程数设置的值
                    //若是LinkedBlockingQueue的话，它会不断的存储任务，永远都不会向最大线程数进行线程的扩展！！！

        //活跃时间和活跃时间的单位: 当线程的空闲时间超过活跃时间，线程就会被回收
        //阻塞队列: 全部核心线程处于忙碌状态，新来的任务放在阻塞队列中
        //最大承载: 队列大小（如果是ArrayBlockingQueue的话）+ 最大的线程数  （若是LinkedBlockingQueue的话，它会不断的存储任务，永远都不会向最大线程数进行线程的扩展）
        //线程工厂: 用于创建线程
        //拒绝策略:
                //AbortPolicy:超过最大承载的话，会发生异常RejectedExecutionException
                //CallerRunsPolicy:哪来的去哪里执行，这里安排不了了！！！！！！！！！！！
                //DiscardPolicy():多的任务都给我扔了，不执行！
                //DiscardOldestPolicy():将最早执行的任务停止掉，来执行新来的任务

        ExecutorService threadPool = new ThreadPoolExecutor(
                3,
                5,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 0; i < 33; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " ok " + finalI);
            });
        }

        threadPool.shutdown();

        //下面这几种创建的线程池 是对上面线程池的参数进行封装 内部还是实现了ThreadPoolExecutor！！！！！！！

        //线程池的作用：统一管理线程，实现线程的复用，更好的利用系统资源
        //四大方法：单个线程的池子；固定线程数的池子；自由伸缩的池子；执行定时任务的池子
        //前两个的阻塞队列为 LinkedBlockingQueue-->>请求OOM
        //CachedThreadPool的阻塞队列为SynchronousQueue
        //ScheduledThreadPool使用的任务队列DelayQueue封装了一个PriorityQueue（执行时间短的被放在前面）
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 33; i++) {
            cachedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //关闭别忘了
        cachedThreadPool.shutdown();

        //TODO 线程池的五种状态
        //RUNNING 接收新任务并处理排队中的任务
        //SHUTDOWN 不接受新任务，处理剩下的任务
        //STOP 不再接收新任务，不处理剩下的任务 ！！！
        //TIDYING 所有线程都执行完了  （tidy整齐的
        //TERMINATED 线程池终止了

        //TODO 线程池的执行流程
        //1. 如果要执行的线程小于核心线程数的话，开启核心线程，直接执行
        //2. 如果大于核心线程数的话，将进程放入阻塞队列中进行排队
        //3. 如果队列中满了话，会开启临时线程执行线程任务
        //4. 如果线程任务超过最大的阈值，也就是大于最大线程数+阻塞队列的值的话，就会采用拒绝策略

        //判断是否停止了
        cachedThreadPool.isTerminated();
        //等待3秒后再进行判断
        cachedThreadPool.awaitTermination(3, TimeUnit.SECONDS);

        //cachedThreadPool.execute(() -> System.out.println("在shutDown之后，将不再能继续执行任务"));

        //强制立即结束
        fixedThreadPool.shutdownNow();
    }
}