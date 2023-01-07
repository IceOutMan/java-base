package com.meiken.lock;

import java.util.concurrent.Semaphore;

public class Semaphore_TEST {

    public static void main(String[] args) throws InterruptedException {
        Semaphore ticketSemaphore = new Semaphore(3);

        for(int i=0; i<10; i++){

            new Thread(() ->{
                try {
                    ticketSemaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " Thread get ticket");
                    Thread.sleep(5000);
                    ticketSemaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "thread-" + i).start();
        }


        Thread.sleep(100000);

    }
}
