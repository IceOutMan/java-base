package com.meiken;

/**
 * @Author glf
 * @Date 2022/1/13
 */
public class DaemonThreadMain {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new DaemonRunner());
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    /**
     * 守护线程
     */
    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                // 10s
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("This is Daemon Thread!");
            }
        }
    }
}
