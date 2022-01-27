package com.meiken.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author glf
 * @Date 2022/1/15
 */
public class ConditionMain {
    public static void main(String[] args) {
        condition_TEST();
    }


    /**
     * 线程之间可以使用 Lock 的 Condition 进行通信
     */
    public static void condition_TEST(){
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

}
