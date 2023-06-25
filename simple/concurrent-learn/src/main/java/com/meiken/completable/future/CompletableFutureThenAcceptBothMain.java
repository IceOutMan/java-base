package com.meiken.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 */
public class CompletableFutureThenAcceptBothMain {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> "World"), (r1, r2) -> {
                    System.out.println(r1 + " " + r2);
                });

        System.out.println("This is Main");
    }


    public static void concurrentFutureNoResult() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Future 1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "Future 2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "Future 3";
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2, future3);

    }

    public static void concurrentFutureUseResult() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Future 1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "Future 2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "Future 3";
        });

        String result = Stream.of(future1, future2, future3).map(CompletableFuture::join).collect(Collectors.joining("#"));
        System.out.println(result);
    }

    public static void serialExecute() {
        CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println("Future 1");
            return "Future 1";
        }).thenAccept((result) -> {
            sleep(1000);
            System.out.println("Future 2, Last Future Result : " + result);
            int a = 0;
            System.out.println(1 / a);
        }).handle((r, e) -> {
            System.out.println("Exception: " + e);
            return r;
        });
    }


    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
