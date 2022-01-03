package com.meiken.sync;

import java.sql.DatabaseMetaData;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author glf
 * @Date 2022/1/3
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        // Wait Thread
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();

        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Notify Thread
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();


    }

    /**
     * Wait
     */
    static class Wait implements Runnable{

        @Override
        public void run() {

            // fetch lock
            synchronized(lock){
                // flag is true ,wait condition
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }catch (InterruptedException e){

                    }
                }
                // flag is false, condition is ok
                System.out.println(Thread.currentThread() + " flag is false. running@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }

    }

    /**
     * Notify
     */
    static class Notify implements Runnable{
        @Override
        public void run() {
            // fetch lock
            synchronized(lock){

                System.out.println(Thread.currentThread() + " hold lock. notify@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                // notify one other thread fetch lock
                lock.notify();
                // notify all other threads fetch lock
                lock.notifyAll();
                flag = false;

                // amuse build condition
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // lock again
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                // amuse build condition
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

