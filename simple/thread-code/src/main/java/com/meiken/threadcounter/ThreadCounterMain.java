package com.meiken.threadcounter;

import java.sql.SQLOutput;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author glf
 * @Date 2021/1/19
 */
public class ThreadCounterMain {
    public static void main(String[] args) {
//        countDownLatchTest();
        cyclicBarrierTest();
    }

    /**
     * await 会等待到 CountDownLatch 的数字减完会被调度到
     * 等待点是 await
     */
    public static void countDownLatchTest(){
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i=0; i < 3;i++){
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread Name :" + Thread.currentThread().getName() +  ",Over");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Thread " + i + " ").start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All Thread Over");
    }

    /**
     * 等待点是 await
     * CyclicBarrier 的计数器，到达屏障点之后会被重置为初始值
     * CyclicBarrier 所有的线程会等待在 await点，直到到达了屏障点（计数器为0）
     * 这里由于到了了屏障点后会重置，所以会进入新一轮的屏障点
     * CyclicBarrier 第二个参数是到达屏障点后执行的逻辑
     * 也可使用 CyclicBarrier 的 reset 方法进行手动重置
     */
    public static void cyclicBarrierTest(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,() -> {
            System.out.println("All Thread OVer");
        });

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 第 1 次处理");
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " 第 2 次处理");
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " 第 3 次处理");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        },"Thread One").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 第 1 次处理");
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " 第 2 次处理");
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " 第 3 次处理");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        },"Thread Two").start();
        System.out.println("INIT");
    }

}
