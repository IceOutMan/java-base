package com.meiken.fork.join;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private int data;


    public MyRecursiveAction(int data){
        this.data = data;
    }

    @Override
    protected void compute() {
        // do some compute
        Random random = new Random();
        data = data +  random.nextInt();

        if(data < 1000){
            MyRecursiveAction subTask = new MyRecursiveAction(data);
            // subTask -> 当前线程的任务队列中
            subTask.fork();

            // 等待 subTask  执行完毕
            subTask.join();
        }

    }
}
