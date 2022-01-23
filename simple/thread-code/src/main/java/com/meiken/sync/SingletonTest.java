package com.meiken.sync;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class SingletonTest {
    /**
     * 饿汉模式 - 初始化类的时候直接初始化好
     */
    public static SingletonTest instanceHungry = new SingletonTest();
    /**
     * 懒汉模式 - 在需要时再创建
     */
    public static SingletonTest instanceLazy = null;
    /**
     * 单重 null 校验，也不安全
     */
    public static SingletonTest instanceSingleCheckNotSafe = null;
    public static SingletonTest instanceNotSafe = null;
    public static volatile SingletonTest instanceSafe;
    private SingletonTest(){}

    /**
     *
     * @return
     */
    public static synchronized SingletonTest newInstance(){
        if(instanceLazy == null){
            instanceLazy = new SingletonTest();
        }

        return instanceLazy;
    }

    /**
     * 只做一层空判断的问题
     * 线程A判断单例为空，获取到锁 -> 创建对象
     * 线程B和线程A同时判断了单例为空，由于锁被A持有，B等待A释放锁， A释放锁后，B会重复创一个对象
     * 而且在指令重排序的问题下，会出现其他线程获取到未初始化的对象的问题
     * @return
     */
    public static SingletonTest newInstanceSingleCheckNotSafe(){
        if(instanceNotSafe == null){
            synchronized (SingletonTest.class){
                instanceNotSafe = new SingletonTest();
            }
        }
        return instanceNotSafe;
    }

    /**
     * instanceTwo
     * 多个线程同时判断 instance == null ，只有一个线程能够构造
     * 可能case 创建 -> 赋予地址 -> 初始化，线程A中，赋予了地址，后面的线程直接判断 != null 然后拿到了一个没有初始化的对象
     * @return
     */
    public static SingletonTest newInstanceNotSafe(){
        if(instanceNotSafe == null){
           synchronized (SingletonTest.class){
               // 这种方式在指令重排序下是不安全的
               // ThreadA获取锁，刚分配至完内存还没初始化，instanceTwo != null,
               // ThreadB 调用了函数，直接就获取对象的地址，其实这时候对象还没初始化完成
               if(instanceNotSafe == null){
                   instanceNotSafe = new SingletonTest();
               }
           }
        }
        return instanceNotSafe;
    }

    /**
     *  instanceSafe 变量使用了 volatile  关键子修饰，禁止了指令重排序
     *  变量会被 创建->初始化->赋值
     * @return
     */
    public static SingletonTest newInstanceSafe(){
        if(instanceSafe == null){
            synchronized (SingletonTest.class){
                if(instanceSafe == null){
                    // 这里指令不会重排序，对象初始化工作完成后才赋予内存地址
                    // 这时其他线程调用此方法，获取的对象是初始化完可以正常使用的
                    instanceSafe = new SingletonTest();
                }
            }
        }
        return instanceSafe;
    }
}
