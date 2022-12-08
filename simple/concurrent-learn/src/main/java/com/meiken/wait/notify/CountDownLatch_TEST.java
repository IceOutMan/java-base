package com.meiken.wait.notify;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Enzo Cotter on 2022/12/8.
 */
public class CountDownLatch_TEST {

    public static void main(String[] args) {
        countDownLatchTest();
    }

    /**
     * await 会等待到 CountDownLatch 的数字减完会被调度到
     * 等待点是 await
     */
    public static void countDownLatchTest() {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread Name :" + Thread.currentThread().getName() + ",Over");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread " + i + " ").start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All Thread Over");
    }
}
