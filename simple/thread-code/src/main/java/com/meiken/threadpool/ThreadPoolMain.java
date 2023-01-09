package com.meiken.threadpool;

import java.util.concurrent.*;

/**
 * @Author glf
 * @Date 2021/1/20
 */
public class ThreadPoolMain {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    public static void newFixedThreadPool_TEST(){
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.execute(() -> {});
        newFixedThreadPool.submit(()->{});
    }

    public static void newSingleThreadExecutor_TEST(){
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(()->{});
        newSingleThreadExecutor.submit(()->{});
    }

    public static void newCachedThreadPool_TEST(){
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.submit(()->{});
        newCachedThreadPool.execute(()->{});
    }

    public static void newSingleThreadScheduledExecutor_TEST(){
        //可以定时执行任务
//        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        //任务 5 秒 后执行
        newSingleThreadScheduledExecutor.schedule(()->{
            System.out.println("Schedule");
        },5, TimeUnit.SECONDS);

        //任务5秒后，以2s的间隔执行
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(()->{
            System.out.println("ScheduleAtFixedRate");
        },5,2,TimeUnit.SECONDS);

        //任务5秒后，以3秒的间隔执行
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(()->{
            System.out.println("ScheduleWithFixedDelay");
        },5,3,TimeUnit.SECONDS  );
    }

}
