package com.meiken.sync;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class SingletonTest {
    //    public static SingletonTest instance = new SingletonTest(); //饿汉模式
    public static SingletonTest instance = null;//懒汉模式
    public static SingletonTest instanceTwo = null;
    public static volatile SingletonTest instanceThree;
    private SingletonTest(){}

    public static synchronized SingletonTest newInstance(){
        if(instance == null){
            instance = new SingletonTest();
        }

        return instance;
    }

    public static SingletonTest newInstanceTwo(){
        if(instanceTwo == null){
           synchronized (SingletonTest.class){
               // 这种方式在指令重排序下是不安全的
               // ThreadA获取锁，刚分配至完内存还没初始化，instanceTwo != null,
               // ThreadB 调用了函数，直接就获取对象的地址，其实这时候对象还没初始化完成
               if(instanceTwo == null){
                   instanceTwo = new SingletonTest();
               }
           }
        }
        return instanceTwo;
    }

    public static SingletonTest newInstanceThree(){
        if(instanceThree == null){
            synchronized (SingletonTest.class){
                if(instanceThree == null){
                    // 这里指令不会重排序，对象初始化工作完成后才赋予内存地址
                    // 这时其他线程调用此方法，获取的对象是初始化完可以正常使用的
                    instanceThree = new SingletonTest();
                }
            }
        }
        return instanceThree;
    }
}
