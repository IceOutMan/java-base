package com.meiken.jmm;

/**
 * 内存屏障
 */
public class JMM_MemoryBarrier {

    int a ;
    int c ;
    public volatile int m1 = 1;
    public volatile int m2 = 2;
    public void readAndWrite(){
        int i = m1; // 第一个 volatile 读
        int j = m2; // 第二个 volatile 读

        c = i + j + 1; // 普通写
        a = i + j; // 普通写

        m1 = i + 1; // 第一个 volatile 写
        m2 = j + 1; // 第二个 volatile 写

    }
}
