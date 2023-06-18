package com.meiken.completable.future;

import java.util.concurrent.CompletableFuture;

/**
 */
public class CompletableFutureThenAcceptMain {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": Future-1");
            return "Future-1";
        }).thenAccept((r) -> {
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": Future-2 Receive From last:" + r);
        }).handle((r, e) -> {
            System.out.println(Thread.currentThread().getName() + ": Handle- r:" + r + " e:" + e);
            return r;
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
