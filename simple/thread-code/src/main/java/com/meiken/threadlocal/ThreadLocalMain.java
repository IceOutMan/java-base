package com.meiken.threadlocal;

/**
 * @Author glf
 * @Date 2021/1/20
 */
public class ThreadLocalMain {
    public static void main(String[] args) {
       threadLocalTest();
    }

    /**
     * Thread 每个线程中有一个 ThreadLocalMap 对象用来存储 <ThreadLocal,Value>
     * ThreadLocal 根据 Thread.currentThread() 去获取 ThreadLocalMap -> 然后根据 ThreadLocal 去获取 Value
     * 在 ThreadLocalMap 中，每一个 ThreadLocal 对应一个 Entry，所以后值会覆盖前值
     */
    public static void threadLocalTest(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread(() -> {
            threadLocal.set("zhang san");
            System.out.println(Thread.currentThread().getName() + "- Value :"  + threadLocal.get());
        },"Thread One").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "- Value :" + threadLocal.get());
        },"Thread Two").start();
    }
}
