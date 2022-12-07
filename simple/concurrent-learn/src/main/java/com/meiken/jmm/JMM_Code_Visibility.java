package com.meiken.jmm;


/**
 * 可见性
 * 内存缓存行的失效的时间不确定 :
 *      while(!initFlag){} 只是一个空循环
 *          1. 缓存行就只缓存了 initFlag，可能要很久很久才失效, 此时就没法感知到 initFlag 在内存中的变化
 *          2. 如果再循环中添加了其他代码， 就肯能让缓存行很快失效，就能感知到 initFlag 在内存中的变化
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
