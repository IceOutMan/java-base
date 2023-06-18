package com.meiken.completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * handle() -> 可以处理异常情况
 * join() -> 等待拿到结果
 * allOf() | anyOf() -> 只关心任务执行成功否，不关注结果
 * thenAccept()   ->  串行执行，接收的是前一个调用的返回结果, 没有返回结果，只处理任务
 * thenCombine()  -> 合并多个结果, 拿到多个结果后进行结果的合并处理
 * thenCompose()  ->  串行执行，接收的是前一个调用的 stage, 然后在stage中处理上一个future结果后, 返回一个结果Future
 * thenAcceptBoth() -> 处理两个 future, 没有返回结果，只处理任务
 */
public class CompletableFutureMain {
    public static void main(String[] args) {
//        concurrentFutureUseResult();
//        serialExecute();
        Object result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("HHHHH");
            return null;
        }).join();

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


    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
