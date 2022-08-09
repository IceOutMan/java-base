package com.meiken.sync.join;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread preThread = Thread.currentThread();
        for(int i=0; i < 10 ;i++){
            // 给每个线程设置前驱线程
            Thread thread = new Thread(new Domino(preThread), String.valueOf(i));
            thread.start();

            preThread = thread;
        }

        // 睡五秒
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate");
    }

    static class Domino implements Runnable{
        private Thread preThread ;
        public Domino(Thread preThread){
            this.preThread = preThread;
        }

        @Override
        public void run() {
            try {
                preThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");

        }
    }
}
