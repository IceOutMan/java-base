package com.meiken.future;

import java.util.concurrent.Callable;

/**
 * @Author glf
 * @Date 2021/1/20
 */
public class SpendTimeThrowExceptionTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Start Spend Time Task");
        Thread.sleep(1000);
        System.out.println("End Spend Time Task");

        int i = 0;
        int r = 10 / i; //会抛异常
        return "SPEND TIME TASK";

    }
}
