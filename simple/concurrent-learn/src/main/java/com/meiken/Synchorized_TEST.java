package com.meiken;

import java.util.List;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class Synchorized_TEST {
    private final String objectLock = new String("block");
    private final String constantLock = "block";

    public void syncBlockStrObjectTest(List<Integer> list){
        synchronized (objectLock){
            list.stream().forEach(item -> {System.out.println("Thread Name : " + Thread.currentThread().getName() + "  value:" + item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    public void syncBlockStrConstantTest(List<Integer> list){
        synchronized (constantLock){
            list.stream().forEach(item -> {System.out.println("Thread Name : " + Thread.currentThread().getName() + "  value:" + item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public synchronized void syncGeneralMethod(List<Integer> list){
        list.stream().forEach(item -> {System.out.println("Thread Name : " + Thread.currentThread().getName() + "  value:" + item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    public static synchronized void syncStaticMethod(List<Integer> list){
        list.stream().forEach(item -> {System.out.println("Thread Name : " + Thread.currentThread().getName() + "  value:" + item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
