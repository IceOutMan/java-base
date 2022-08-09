package com.meiken.sync.message.wait.notify;

import java.util.concurrent.TimeUnit;

public class WaitNotify {

    public static boolean FLAG = true;
    public static Object lock = new Object();


    public static void main(String[] args) {
        // Wait Thread
        Thread waitThread = new Thread(new Wait(lock), "WaitThread");
        waitThread.start();

        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Notify Thread
        Thread notifyThread = new Thread(new Notify(lock), "NotifyThread");
        notifyThread.start();
    }
}
