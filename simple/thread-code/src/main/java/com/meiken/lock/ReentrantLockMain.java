package com.meiken.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可冲入锁
 * @Author glf
 * @Date 2022/1/15
 */
public class ReentrantLockMain {

    public static void main(String[] args) {
        reentrantLock_TEST();
    }

    /**
     * 使用可重入锁,这里不使用 synchorized 关键字
     */
    public static void reentrantLock_TEST(){
        // 带有公平锁 和 非公平锁的参数
        Lock lock = new ReentrantLock();

        new Thread(() -> {
            reentrantLockMethod(lock);
        },"Thread1").start();

        new Thread(() -> {
            reentrantLockMethod(lock);
        },"Thread2").start();

        new Thread(() -> {
            reentrantLockMethod(lock);
        },"Thread3").start();
    }

    public static void reentrantLockMethod(Lock lock){
        lock.lock();
        for (int i=0;i<5;i++){
            System.out.println("ThreadName:" + Thread.currentThread().getName() + " i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        lock.unlock();
    }


}
