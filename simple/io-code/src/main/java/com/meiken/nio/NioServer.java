package com.meiken.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;

public class NioServer {

    static HashSet<SocketChannel> channelSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // 创建 NIO ServerSocketChannel ， 与BIO的 serverSocket 类似
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        // 设置 ServerSocketChannel 为非阻塞方式
        serverSocket.configureBlocking(false);
        System.out.println("server start");
        while(true){
            // 非阻塞模式 accept 方法不会阻塞
            // NIO 的非阻塞由操作系统内部实现，底层调用了 Linux 内核的 accept 函数
            SocketChannel socketChannel = serverSocket.accept();
            if(socketChannel != null){
                System.out.println("client connection success");
                // 设置 SocketChannel 为非阻塞
                socketChannel.configureBlocking(false);

                channelSet.add(socketChannel);
            }

            // 遍历连接进行数据读取
            Iterator<SocketChannel> iterator = channelSet.iterator();
            while (iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                // 非阻塞模式 read 方法不会阻塞
                int len = sc.read(byteBuffer);
                if(len > 0){
                    // 如果有数据 打印数据
                    System.out.println("server receive : " + new String(byteBuffer.array()));
                }else if(len == -1){
                    // 如果客户端断开，socket 从集合中移除
                    channelSet.remove(sc);
                    System.out.println("client close connection");
                }

            }
        }

    }
}
