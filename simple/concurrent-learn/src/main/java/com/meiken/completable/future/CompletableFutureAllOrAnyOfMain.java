package com.meiken.completable.future;

import java.util.concurrent.CompletableFuture;

/**
 * handle() -> 可以处理异常情况
 * join() -> 等待拿到结果
 * allOf() | anyOf() -> 只关心任务执行成功否，不关注结果
 *
 */
public class CompletableFutureAllOrAnyOfMain {
    public static void main(String[] args) {
        andOf();
    }

    public static void andOf() {
        CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": Future-1");
            return "Future-1";
        });
        CompletableFuture<String> futureTwo = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            System.out.println(Thread.currentThread().getName() + ": Future-2");
            return "Future-2";
        });
        CompletableFuture<String> futureThree = CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": Future-3");
            return "Future-3";
        });

        CompletableFuture.anyOf(futureOne, futureTwo, futureThree).join();
        System.out.println("This is Main");
    }

    public static void allOf() {
        CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": Future-1");
            return "Future-1";
        });
        CompletableFuture<String> futureTwo = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            System.out.println(Thread.currentThread().getName() + ": Future-2");
            return "Future-2";
        });
        CompletableFuture<String> futureThree = CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": Future-3");
            return "Future-3";
        });

        CompletableFuture.allOf(futureOne, futureTwo, futureThree).join();
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
