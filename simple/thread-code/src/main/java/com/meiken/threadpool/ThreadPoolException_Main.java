package com.meiken.threadpool;

import java.util.concurrent.*;

/**
 * execute 某个任务异常（如果没有被 try-catch, 线程会被挂掉，异常会被抛出取) → 继续执行其他任务就需要重新找一个线程
 * submit 某个任务异常（任务会被丢弃,如果没有被try-catch, 异常会被吞掉，线程继续存活） → 继续执行其他任务
 */
public class ThreadPoolException_Main {
    public static void main(String[] args) {
        submit_exception();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        execute_exception();
    }

    public  static void submit_exception(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " will submit exception task");
                try {
                    int a = 1/0;
                }catch (Exception e){
                    System.out.println("xxxx");
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " will submit exception task");
                int a = 1/0;
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() +  " continue task after last submit task exception");
            }
        });
    }

    public static void execute_exception(){
        System.out.println("=============================================");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " will execute exception task");
                int a = 1/0;
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() +  " continue task after last execute task exception");
            }
        });
    }
}
