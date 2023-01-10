package com.meiken.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池
 */
public class ScheduledThreadPoolExecutor_Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        // 异步任务
//        scheduledThreadPoolExecutor.schedule(
//                () -> {
//                    System.out.println("延迟5秒执行");
//
//                },
//                5000, TimeUnit.MILLISECONDS);


        //  异步任务 -> 获取结果
//        ScheduledFuture<Integer>  future = scheduledThreadPoolExecutor.schedule(
//                () -> {
//                    System.out.println("延迟5秒执行");
//                    return 1;
//
//                },
//                5000, TimeUnit.MILLISECONDS);
//
//         等待结果
//        System.out.println(future.get());

        // 发送💗心跳 -> 1s钟后开始执行 -> 每2s执行一次
//        scheduledThreadPoolExecutor.scheduleAtFixedRate( () -> {
//            System.out.println("发送心跳~ bound bound ");
//
//
//        },1000, 2000, TimeUnit.MILLISECONDS);

        // 执行任务，任务执行时间 + DelayTime = 下次任务执行时间
        scheduledThreadPoolExecutor.scheduleWithFixedDelay( ()->{
            System.out.println("发送心跳~ bound bound");

        }, 1000, 2000, TimeUnit.MILLISECONDS);

    }

}
