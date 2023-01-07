package com.meiken;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by Enzo Cotter on 2022/12/8.
 */
public class ObjectHeader_Print {
    public static void main(String[] args) {
        Object o = new Object();
        /*
        * HashCode 为空， 由于是懒打印，使用这个工具初始化打印为空 正常
        *  00000001 00000000 00000000 00000000  小端存储
        *  00000000 00000000 00000000 00000001
        **/
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized(o){
            /*
             * 没有竞争：轻量级锁, JVM延迟启动偏向锁
             *  11000000 11011001 10110000 00001101  小端存储
             *  00001101 10110000 11011001 11000000
             **/
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
