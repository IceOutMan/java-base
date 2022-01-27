package com.meiken.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @Author glf
 * @Date 2022/1/15
 */
public class ReadWriteLockMain {
    public static void main(String[] args) {

        readWriteLock_TEST();
    }

    /**
     * 读写互斥
     * 写读互斥
     * 写写互斥
     * 读读不互斥
     */
    public static void readWriteLock_TEST(){
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        // read
        new Thread(()->{
            readMethod(reentrantReadWriteLock);
        },"Thread Read One").start();

        // read
        new Thread(()->{
            readMethod(reentrantReadWriteLock);
        },"Thread Read Two").start();
        // write
        new Thread(()->{
            writeMethod(reentrantReadWriteLock);
        },"Thread Write One").start();
        // write
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
