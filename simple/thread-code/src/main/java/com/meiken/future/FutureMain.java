package com.meiken.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author glf
 * @Date 2021/1/20
 */
public class FutureMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        futureTaskTest();
        futureTaskThrowExceptionTest();
    }


    /**
     * @throws ExecutionException
     * @throws InterruptedException
     * SpendTimeTask 实现了Callable接口，去做耗时操作
     * FutureTask有一个 Callable对象，get方法会等待耗时操作执行完毕返回
     */
    public static void futureTaskTest() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new SpendTimeTask());
        new Thread(futureTask).start();

        System.out.println("DO OTHER THING");
        Thread.sleep(3000);
        System.out.println("OTHER THING OVER");

        System.out.println(futureTask.get());

    }

    /**
     * 可以捕获到 FutureTask 中的 Callable 的异常
     */
    public static void futureTaskThrowExceptionTest(){
        try {
            FutureTask<String> futureTask = new FutureTask<>(new SpendTimeThrowExceptionTask());
            new Thread(futureTask).start();

            System.out.println("DO OTHER THING");
            Thread.sleep(3000);
            System.out.println("OTHER THING OVER");

            System.out.println(futureTask.get());
        } catch (Exception e) {
            System.out.println("Catch Future Exception");
            e.printStackTrace();
        }
    }
}
