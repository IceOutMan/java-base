package com.meiken;

/**
 * @Author glf
 * 死锁
 * @Date 2022/11/7
 */
public class DeadLockTest {
    private static Object lock_1 = new Object();
    private static Object lock_2 = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (lock_1){
                try {
                    System.out.println("thread_1 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }

                synchronized (lock_2){
                    System.out.println("thread_1 end");
                }
            }


        }).start();

        new Thread(()->{
            synchronized (lock_2){
                try {
                    System.out.println("thread_2 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (lock_1){
                    System.out.println("thread_2 end");
                }
            }

        }).start();

        System.out.println("main is end");
    }

}
