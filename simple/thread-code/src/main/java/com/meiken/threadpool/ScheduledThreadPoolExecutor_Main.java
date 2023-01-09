package com.meiken.threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池
 */
public class ScheduledThreadPoolExecutor_Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);

        scheduledThreadPoolExecutor.schedule(
                () -> {
                    System.out.println("延迟5秒执行");

                },
                5000, TimeUnit.MILLISECONDS);

    }

}
