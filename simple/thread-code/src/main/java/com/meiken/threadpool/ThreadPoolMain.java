package com.meiken.threadpool;

import java.util.concurrent.*;

/**
 * @Author glf
 * @Date 2021/1/20
 */
public class ThreadPoolMain {

    public static void main(String[] args) {

//        baseUseTest();
        threadPoolExecutorTest();
    }


    public static void baseUseTest(){
//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
//        newFixedThreadPool.execute(() -> {});
//        newFixedThreadPool.submit(()->{});
//
//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
//        newSingleThreadExecutor.execute(()->{});
//        newSingleThreadExecutor.submit(()->{});
//
//        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        newCachedThreadPool.submit(()->{});
//        newCachedThreadPool.execute(()->{});

        //可以定时执行任务
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        newSingleThreadScheduledExecutor.schedule(()->{
            System.out.println("Schedule");
        },5, TimeUnit.SECONDS); //任务 5 秒 后执行
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(()->{
            System.out.println("ScheduleAtFixedRate");
        },5,2,TimeUnit.SECONDS); //任务5秒后，以2s的间隔执行
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(()->{
            System.out.println("ScheduleWithFixedDelay");
        },5,3,TimeUnit.SECONDS  );//任务5秒后，以3秒的间隔执行

//        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);

        new ThreadPoolExecutor(
                2,//核心线程数 - 可以运行的线程数
                4,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(5),//队列一定要设置大小
                Executors.defaultThreadFactory(),//默认的线程创建工厂
                new ThreadPoolExecutor.AbortPolicy());//拒绝策略

    }

    /**
     * corePoolSize = 2
     * workQueue = 2
     * maximunPoolSize = 10
     *
     * 1.任务创建两个核心线程
     * 2.后续的两个任务进入 workQueue
     * 3.后续的任务会创建新的线程，核心线程 + 额外创建的线程 （不包含任务)  线程超过最大线程数会被拒绝策略拒绝，抛出异常
     */
    public static void threadPoolExecutorTest(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));
        for (int i = 0; i < 13; i++) {
            threadPool.submit(() -> {
                try {
                    System.out.println("Thread Name :" + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread Pool Size: " + threadPool.getPoolSize() + " Max Pool Size: "  + threadPool.getMaximumPoolSize() );
        }
    }
}
