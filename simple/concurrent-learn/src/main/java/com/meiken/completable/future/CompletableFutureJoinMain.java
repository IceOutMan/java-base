package com.meiken.completable.future;

import java.util.concurrent.CompletableFuture;

/**
 */
public class CompletableFutureJoinMain {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ": Future-1");
                    return "Future-1";
                }).join();

        System.out.println("This is Main");
    }


    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
