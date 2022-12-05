package com.meiken;


/**
 * Created by Enzo Cotter on 2022/12/5.
 */
public class JMM_Code_Visibility {

    private volatile static boolean initFlag = false;

    public static void refresh() {
        System.out.println("refresh before");
        initFlag = true;
        System.out.println("refresh after");
    }

    public static void main(String[] args) {

        new Thread(() -> {
            while (!initFlag) {
            }
            System.out.println("Listener initFlag changed!");
        }, "Thread-A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            refresh();
        }, "Thread-B").start();
    }

}
