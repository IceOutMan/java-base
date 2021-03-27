package com.meiken.future;

import java.util.concurrent.Callable;

/**
 * @Author glf
 * @Date 2021/1/20
 */
public class SpendTimeTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Start Spend Time Task");
        Thread.sleep(1000);
        System.out.println("End Spend Time Task");
        return "SPEND TIME TASK";
    }
}
