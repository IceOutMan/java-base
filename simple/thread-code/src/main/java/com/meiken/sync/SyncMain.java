package com.meiken.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class SyncMain {
    public static void main(String[] args) throws InterruptedException {


//        syncBlockStrObjectTest();
//        Thread.sleep(5000);
//        syncBlockStrConstantTest();
//        Thread.sleep(5000);
        waitNotifyTest();
    }

    public static void syncBlockStrConstantTest(){
        // SynchorizedTest -> The Lock is Constant ,So Two Object have the same Lock
        System.out.println("SYNC BOLCK STR CONSTANT TEST");
        List<Integer> list = List.of(1,2,3,4,5);
        SynchorizedTest synchorizedTestOne = new SynchorizedTest();
        SynchorizedTest synchorizedTestTwo = new SynchorizedTest();

        new Thread(() -> synchorizedTestOne.syncBlockStrConstantTest(list),"Thread 1").start();
        new Thread(() -> synchorizedTestTwo.syncBlockStrConstantTest(list), "Thread 2").start();

    }
    public static void syncBlockStrObjectTest(){
        System.out.println("SYNC BOLCK STR OBJECT TEST");
        //SynchorizedTest -> The Lock is Object, So Two Object have two Lock
        List<Integer> list = List.of(1,2,3,4,5);
        SynchorizedTest synchorizedTestOne = new SynchorizedTest();
        SynchorizedTest synchorizedTestTwo = new SynchorizedTest();

        new Thread(() -> synchorizedTestOne.syncBlockStrObjectTest(list),"Thread 3").start();
        new Thread(() -> synchorizedTestTwo.syncBlockStrObjectTest(list), "Thread 4").start();

    }

    /**
     * wait()  —> 释放锁
     * notify() -> 不释放锁，线程执行完
     */
    public static void waitNotifyTest(){
        System.out.println("WATI NOTIFY TEST");
        List<Integer> list = new ArrayList<>();
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock){
                if(list.size() != 5){
                    System.out.println(Thread.currentThread().getName() + " , Wait For Number");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ", Get Number");

                }

            }
        },"Tread Wait Number").start();

        new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                    System.out.println(Thread.currentThread().getName() + "，添加了第 " + (i+1) + " 个元素");
                    if(list.size() == 5){
                        lock.notify();
                        System.out.println("Notify Wait Single Thread");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Thread Add Element").start();
    }
}
