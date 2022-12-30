package com.meiken;

import java.util.concurrent.locks.LockSupport;

public class LockSupport_Main {

    public static void main(String[] args) {

        Thread t0 = new Thread(() ->{
            System.out.println("t0 interrupted : " + Thread.currentThread().isInterrupted());
            LockSupport.park(Thread.currentThread());
            while(true){
                System.out.println("this is t0");
            }
        });
        t0.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t0.interrupt();

        System.out.println("t0 interrupted : " + t0.isInterrupted());


    }
}
