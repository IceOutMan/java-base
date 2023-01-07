package com.meiken;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author glf
 * @Date 2022/12/29
 */
public class LockSupport_Main {
    public static void main(String[] args) {
        Thread t0 = new Thread(
                () -> {
                    Thread currentThread = Thread.currentThread();
                    System.out.println("开始执行：" + currentThread.getName());

                    for(;;){
                        System.out.println("准备park住当前线程：" + currentThread.getName());
                        LockSupport.park();
                        System.out.println("当前线程：" + currentThread.getName() + "已被唤醒");
                    }
                }
        , "t0");

        t0.start();

        try{
            Thread.sleep(5000);
            System.out.println("准备唤醒：" + t0.getName());
            LockSupport.unpark(t0);
        }catch (Exception e){

        }

    }
}
