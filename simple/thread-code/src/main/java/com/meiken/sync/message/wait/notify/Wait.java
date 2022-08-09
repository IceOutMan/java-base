package com.meiken.sync.message.wait.notify;



import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Wait
 */
public class Wait implements Runnable{

    private Object lock;

    public Wait(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {

        // fetch lock
        synchronized(lock){
            // flag is true ,wait condition
            while (WaitNotify.FLAG){
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