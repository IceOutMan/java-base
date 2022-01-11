package com.meiken.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author glf
 * @Date 2022/1/11
 */
public class CustomDefineThreadPool {
    public static void main(String[] args) {
        customDefineThreadPool_TEST();
    }



    /**
     * corePoolSize: 线程池核心线程的个数
     * maximumPoolSize: 线程池的大小
     * keepAliveTime: 线程空闲存活的时间
     * TimeUnit: keepAliveTime的单位
     * workQueue: 队列一定要设置大小
     * threadFactory: Executors.defaultThreadFactory() 默认的线程创建工厂
     * handler:
     */
    public static void customDefineThreadPool_TEST(){

//        new ThreadPoolExecutor(
//                2,
//                4,
//                100,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<Runnable>(5),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());


        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(8));
        for (int i = 0; i < 13; i++) {
            threadPool.submit(() -> {
                try {
                    System.out.println("Thread Name :" + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // 100ms 后创建下一个任务,保证在第一个任务没有执行完前塞进去所有任务  并查看一次线程池状态
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            printThreadPoolInfo(threadPool);

        }

        // 每间隔一秒查询一次线程池的状态
        for (int i=0; i< 20 ;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printThreadPoolInfo(threadPool);
        }

        // 销毁线程池
        threadPool.shutdownNow();

        // 查看线程信息
        printThreadPoolInfo(threadPool);
    }

    public static void printThreadPoolInfo(ThreadPoolExecutor threadPoolExecutor){
        System.out.println("[Thread Pool Size] : " + threadPoolExecutor.getPoolSize() +
                " [Max Pool Size]: "  + threadPoolExecutor.getMaximumPoolSize()  +
                " [Task Count]: " + threadPoolExecutor.getTaskCount()  +
                " [LargestPoolSize]:" + threadPoolExecutor.getLargestPoolSize() +
                " [Activity Count]: " + threadPoolExecutor.getActiveCount() +
                " [Completed Task Count]: " + threadPoolExecutor.getCompletedTaskCount()
        );
    }
}
