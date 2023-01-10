package com.meiken.fork.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

public class ForkJoin_Main {

    public static void main(String[] args) {

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(10);
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        forkJoinPool.invoke(myRecursiveAction);

    }
}
