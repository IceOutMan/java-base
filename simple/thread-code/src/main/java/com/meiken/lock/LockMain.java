package com.meiken.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author glf
 * @Date 2021/1/19
 */
public class LockMain {
    /**
     * 1. 获得到锁的线程可以响应中断 ,抛出中断异常的同时会释放锁
     * 2. 支持会尝试非阻塞地获取锁  [ boolean tryLock() ]
     * 3. 支持超时获取锁的方式
     * 4. 使用 Lock 的 Condition 组件进行进程间通信
     * @param args
     */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
//        lock.lock();
//        lock.lockInterruptibly();
//        lock.tryLock();
        boolean lockBoolean = false;
        try {
            lockBoolean = lock.tryLock(100, TimeUnit.SECONDS);
            // do task
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lockBoolean){
                lock.unlock();
            }
        }
    }

}
