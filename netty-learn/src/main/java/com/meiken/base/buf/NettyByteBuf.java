package com.meiken.base.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * netty -> ByteBuf
 */
public class NettyByteBuf {

    public static void main(String[] args) {
        // 创建 byteBuf 对象，该对象内部包含一个字节数组 byte[10]
        // 通过 readerIndex 和 writerIndex 和 capacity ， 将 buffer 分成三个区域
        // 已经读取的区域 [0, readerIndex)
        // 可读取的区域  [readerIndex, writerIndex)
        // 可写的区域 [writerIndex, capacity]
        ByteBuf  byteBuf = Unpooled.buffer(10);
        System.out.println("byteBuf=" + byteBuf);

        // 写
        for (int i = 0; i < 8; i++) {
            byteBuf.writeByte(i);
        }
        System.out.println("byteBuf=" + byteBuf);

        // 读
        System.out.println("getByte ->======");
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.getByte(i));
        }
        System.out.println("byteBuf=" + byteBuf);


        // 读
        System.out.println("readByte ->======");
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.readByte());
        }
        System.out.println("byteBuf=" + byteBuf);

        // 使用 Unpooled 工具类创建 ByteBuf
        ByteBuf byteBuf2 = Unpooled.copiedBuffer("hello,byte buf2".getBytes(CharsetUtil.UTF_8));
        // 使用相关的方法
        if(byteBuf.hasArray()){
            byte[] content = byteBuf2.array();
            // 将 content 转换成字符串
            System.out.println(new String(content, CharsetUtil.UTF_8));
            System.out.println("byteBuf2=" + byteBuf2);

            System.out.println("base info -> ======");
            System.out.println(byteBuf2.readerIndex()); // 0
            System.out.println(byteBuf2.writerIndex()); // 15
            System.out.println(byteBuf2.capacity()); // 15

            System.out.println(byteBuf2.getByte(0)); // 获取数组0这个位置的字符 h 的ascii码， h=104

            int len =byteBuf2.readableBytes(); // 可读的字节数 15
            System.out.println("len=" + len);

            // 使用 for 取出各个字节
            System.out.println("for get byte -> ======");
            for (int i = 0; i < len; i++) {
                System.out.println((char)byteBuf2.getByte(i));
            }


            // 范围 读取
            System.out.println("get char sequence -> =====");
            System.out.println(byteBuf2.getCharSequence(0,6,CharsetUtil.UTF_8));
            System.out.println(byteBuf2.getCharSequence(6, 9, CharsetUtil.UTF_8));

        }
    }
}
