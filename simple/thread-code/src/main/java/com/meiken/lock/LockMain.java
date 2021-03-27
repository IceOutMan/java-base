package com.meiken.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author glf
 * @Date 2021/1/19
 */
public class LockMain {
    public static void main(String[] args) {

//        reentrantLockTest();
//        waitAndSignalTest();
        writeAndReadLockTest();
    }


    /**
     * 使用可重入锁,这里不使用 synchorized 关键字
     */
    public static void reentrantLockTest(){
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

    /**
     * 使用 Lock 获取 Condition 来实现 线程等待和唤醒操作
     */
    public static void waitAndSignalTest(){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            lock.lock();
            System.out.println("IM Thread:" + Thread.currentThread().getName() + ",I Will await...");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("IM Thread:" + Thread.currentThread().getName() + ", I Get Signal");
            lock.unlock();
        },"Thread One").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("IM Thread:" + Thread.currentThread().getName() + ", I Will Send Signal...");
            condition.signal();
            System.out.println("IM Thread:" + Thread.currentThread().getName() + ", I have Send a Signal");
            lock.unlock();
        },"Thread Two").start();
    }

    /**
     * 读读 不互斥
     * 读写锁 互斥
     * 写写锁 互斥
     */
    public static void writeAndReadLockTest(){
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        new Thread(()->{
            readMethod(reentrantReadWriteLock);
        },"Thread Read One").start();
        new Thread(()->{
            readMethod(reentrantReadWriteLock);
        },"Thread Read Two").start();
        new Thread(()->{
            writeMethod(reentrantReadWriteLock);
        },"Thread Write One").start();
        new Thread(()->{
            writeMethod(reentrantReadWriteLock);
        },"Thread Write Two").start();


    }
    public static void readMethod(ReentrantReadWriteLock lock){
        lock.readLock().lock();
        System.out.println("Thread Name :" + Thread.currentThread().getName() + "，获得读锁，时间:" + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
    }
    public static void writeMethod(ReentrantReadWriteLock lock){
        lock.writeLock().lock();
        System.out.println("Thread Name :" + Thread.currentThread().getName() + ",获的写锁，时间：" + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.writeLock().unlock();
    }
}
