// package fantastzjy.threadPool;
//
// import cn.hutool.core.thread.ThreadFactoryBuilder;
// import com.google.common.collect.Lists;
// import lombok.extern.slf4j.Slf4j;
//
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.concurrent.*;
// import java.util.concurrent.atomic.AtomicInteger;
//
// /**
//  * 拒绝任务:
//  * 1. CallerRunsPolicy ：这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功。(降级调用主线程执行)
//  * 2. AbortPolicy ：对拒绝的任务抛弃处理，并且抛出异常。  RejectedExecutionException
//  * 3. DiscardPolicy ：对拒绝的任务直接无声抛弃，没有异常信息。
//  * 4. DiscardOldestPolicy ：对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个任务，然后把拒绝任务加到队列。
//  */
// @Slf4j
// public class ThreadPoolApi {
//
//     public static void main(String[] args) {
//
//
//         //000 111111111 1111111111 1111111111
//         int CAPACITY = (1 << 29) - 1;
//         System.out.println(Integer.toBinaryString(CAPACITY));
//
//         //111 000000000 0000000000 0000000000
//         int RUNNING = -1 << COUNT_BITS;
//         System.out.println(Integer.toBinaryString(RUNNING));
//
//         //111 000000000 0000000000 0000000000
//         AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
//         System.out.println(Integer.toBinaryString(ctl.get()));
//
//         //cash1:流量过大,触发拒绝策略,抛出RejectedExecutionException
//         rejectedTaskCase();
//         //cash2:任务超时,某项子任务超时,影响其他任务输出.场景
//         //timeOutCase();
//         //cash3:大量任务堆积在队列中，任务执行时间过长，最终导致下游服务的大量调用超时失败
//         //clientApi();
//     }
//
//     //任务堆积,导致上游服务请求超时.
//     //可能原因,
//     // 1:线程池中线程数量不足,导致任务堆积在队列中,
//     // 2:任务执行时间过长(依赖服务超时),最终导致上游服务的大量调用超时失败
//     private static void clientApi() {
//         ThreadPoolExecutor threadPoolCase = new ThreadPoolExecutor(
//                 10,
//                 12,
//                 60,
//                 TimeUnit.SECONDS,
//                 new ArrayBlockingQueue<>(100),
//                 ThreadFactoryBuilder.create().setNamePrefix("上游服务-").build(),
//                 new ThreadPoolExecutor.AbortPolicy()
//         );
//         //模拟上游请求
//         for (int i = 0; i < 10; i++) {
//             CompletableFuture<Void> future = CompletableFuture.runAsync(
//                     () -> {
//                         List<Integer> resultList = serviceApi();
//                         log.info("详情数据:{}", resultList);
//                     }, threadPoolCase);
//             try {
//                 future.get(300, TimeUnit.MILLISECONDS);
//             } catch (InterruptedException | ExecutionException | TimeoutException e) {
//                 log.error("模拟超时异常 message:{},StackTrace:{}", e.getMessage(), e.getStackTrace(), e);
//             }
//         }
//     }
//
//     static ThreadPoolExecutor heapUpTimeOut2ThreadPoolCase = new ThreadPoolExecutor(
//             2,
//             4,
//             60,
//             TimeUnit.SECONDS,
//             new ArrayBlockingQueue<>(10),
//             ThreadFactoryBuilder.create().setNamePrefix("heapUpTimeOut2ThreadPoolCase-").build(),
//             new ThreadPoolExecutor.AbortPolicy()
//     );
//
//     private static List<Integer> serviceApi() {
//         List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//         CompletableFuture<Void> caseA = CompletableFuture.runAsync(
//                 () -> {
//                     for (int i = 0; i < 3; i++) {
//                         list.add(i);
//                     }
//                 }, heapUpTimeOut2ThreadPoolCase);
//         CompletableFuture<Void> caseB = CompletableFuture.runAsync(
//                 () -> {
//                     try {
//                         Thread.sleep(3000);
//                     } catch (InterruptedException ignored) {
//                     }
//                     for (int i = 10; i < 13; i++) {
//                         list.add(i);
//                     }
//                 }, heapUpTimeOut2ThreadPoolCase);
//         try {
//             CompletableFuture.allOf(caseA, caseB).get(200, TimeUnit.MILLISECONDS);
//         } catch (Exception e) {
//             if (e instanceof TimeoutException) {
//                 log.error("serviceApi TimeoutException message:{}", e.getMessage());
//             } else if (e instanceof RejectedExecutionException) {
//                 log.error("serviceApi RejectedExecutionException");
//             } else {
//                 log.error("serviceApi 系统异常 message:{}", e.getMessage());
//             }
//         }
//         return list;
//     }
//
//
//     private static List<Integer> timeOutCase() {
//         ThreadPoolExecutor mergeThreadPoolCase = new ThreadPoolExecutor(
//                 2,
//                 2,
//                 60,
//                 TimeUnit.SECONDS,
//                 new ArrayBlockingQueue<>(1),
//                 ThreadFactoryBuilder.create().setNamePrefix("mergeThreadCash-").build(),
//                 new ThreadPoolExecutor.AbortPolicy()
//                 //new ThreadPoolExecutor.CallerRunsPolicy()
//         );
//         List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//         CompletableFuture<Void> caseA = CompletableFuture.runAsync(
//                 () -> {
//                     log.info("A执行子线程任务:{}", Thread.currentThread().getName());
//                     for (int i = 0; i < 3; i++) {
//                         list.add(i);
//                         log.info("A add:{} 线程:{}", i, Thread.currentThread().getName());
//                     }
//                 }, mergeThreadPoolCase);
//         CompletableFuture<Void> caseB = CompletableFuture.runAsync(
//                 () -> {
//                     try {
//                         log.info("B模拟底层执行耗时大于1000ms");
//                         Thread.sleep(1000);
//                     } catch (InterruptedException ignored) {
//                     }
//                     log.info("B执行子线程任务:{}", Thread.currentThread().getName());
//                     for (int i = 100; i < 103; i++) {
//                         list.add(i);
//                         log.info("B add:{} 线程:{}", i, Thread.currentThread().getName());
//                     }
//                 }, mergeThreadPoolCase);
//         try {
//             CompletableFuture.allOf(caseA, caseB).get(200, TimeUnit.MILLISECONDS);
//             return list;
//         } catch (Throwable e) {
//             log.error("其他异常 message:{},StackTrace:{}", e.getMessage(), e.getStackTrace(), e);
//         }
//         return Lists.newArrayList();
//     }
//
//
//     /**
//      * RejectedExecutionException
//      * 1).可以捕获异常,进行限流处理. RejectedExecutionException
//      * 2).适当增加阻塞队列大小或线程数量
//      * 3).如果对耗时任务不敏感,可以使用 CallerRunsPolicy 策略,将任务交给主线程执行
//      */
//     private static void rejectedTaskCase() {
//         ThreadPoolExecutor rejectedThreadPool = new ThreadPoolExecutor(
//                 1,
//                 2,
//                 60,
//                 TimeUnit.SECONDS,
//                 new ArrayBlockingQueue<>(1),
//                 ThreadFactoryBuilder.create().setNamePrefix("rejectedCash-").build(),
//                 new ThreadPoolExecutor.AbortPolicy()
//                 //new ThreadPoolExecutor.CallerRunsPolicy()
//         );
//         for (int i = 0; i < 5; i++) {
//             try {
//                 int finalI = i;
//                 CompletableFuture.runAsync(
//                         () -> {
//                             log.info("正常执行 {} 任务 ,线程 : {}", finalI, Thread.currentThread().getName());
//                             try {
//                                 Thread.sleep(200);
//                             } catch (InterruptedException ignored) {
//                             }
//                         }, rejectedThreadPool);
//             } catch (Exception e) {
//                 if (e instanceof RejectedExecutionException) {
//                     log.error("拒绝执行抛出 RejectedExecutionException 异常 {} 任务 ,线程 : {}", i, Thread.currentThread().getName());
//                 } else {
//                     log.info("执行异常 错误信息 :{}", e.getMessage(), e);
//                 }
//             }
//         }
//         rejectedThreadPool.shutdown();
//     }
// }
