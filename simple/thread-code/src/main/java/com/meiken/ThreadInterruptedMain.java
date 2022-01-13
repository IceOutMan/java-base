package com.meiken;

/**
 * @Author glf
 * @Date 2022/1/13
 */
public class ThreadInterruptedMain {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        // 休眠5s，让两个线程充分启动起来
        Thread.sleep(5000);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        // 防止Main一结束 两个守护线程直接退出了
        Thread.sleep(2000);
    }

    // 不断睡眠
    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // 一直忙碌的线程
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){

            }

        }
    }
}
