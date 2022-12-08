package com.meiken.wait.notify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notify_TEST implements Runnable{
    private Object lock;

    public Notify_TEST(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        // fetch lock
        synchronized(lock){

            System.out.println(Thread.currentThread() + " hold lock. notify@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            /************************************************
             *    这里二选一即可
             * 1. notify one other thread fetch lock
             * 2. notify all other threads fetch lock
             * ***********************************************
             */
            lock.notify();
//            lock.notifyAll();
            WaitNotify_TEST.FLAG = false;

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
