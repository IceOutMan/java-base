package com.meiken.baseuse;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class BaseUseMain {
    public static void main(String[] args) {
//        startThreadByImplementRunnable();
//        startThreadByInheritThread();
//        startThreadByLambada();
        threadThrowException();
    }


    public static void startThreadByInheritThread(){
        MyThread thread = new MyThread();
        thread.start();
    }
    public static void startThreadByImplementRunnable(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
    public static void startThreadByLambada(){
        new Thread(() -> {
            System.out.println("Lambada Thread");
        }).start();
    }

    /**
     * 说明 线程中的异常是可以打印出来的
     * 但是，捕获不到
     * 所以，线程内有问题要内部处理
     */
    public static void threadThrowException(){
        try{
            new Thread(() -> {
                int i = 0;
                int r = 10 / i;
            }).start();
        }catch (Exception e){
            System.out.println("Catch Thread Exception");
            e.printStackTrace();
        }
   }
}

