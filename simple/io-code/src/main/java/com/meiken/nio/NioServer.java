package com.meiken.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    private static ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws IOException {
        try (Selector selector = Selector.open()) {

            // ServerSocketChannel  ->  ServerSocket
            // SocketChannel -> Socket
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(9000));
            // 设置 ServerSocketChannel 为非阻塞方式
            serverSocket.configureBlocking(false);

            // serverSocket 注册为 ACCEPT 事件，改 socket只关心 accept 事件
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("server start");
            while (true) {
                // 阻塞在 select 这里, 等待就绪的 channel
                selector.select();

                // 发生了事件的 key
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIter = selectionKeys.iterator();
                while(selectionKeyIter.hasNext()){
                    SelectionKey key = selectionKeyIter.next();

                    // 如果是 accept 事件
                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        // 拿到发起连接的客户端的 SocketChannel
                        SocketChannel socketChannel = server.accept();

                        // 注册 SocketChannel -> Selector｜READ
                        registerChannel(selector, socketChannel, SelectionKey.OP_READ);
                        // 向客户端发送一条打招呼的消息
                        sayHello(socketChannel);
                    }

                    // 如果是 read 事件
                    if(key.isReadable()){
                        readDataFromSocket(key);
                    }

                    // 从事件集合中移除本次处理的 key，防止下次 select 重复处理
                    selectionKeyIter.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerChannel(Selector selector, SocketChannel socketChannel, int ops) throws Exception{
        if(socketChannel == null){
            return;
        }

        // 设置 channel 非阻塞
        socketChannel.configureBlocking(false);

        // 注册到 selector
        socketChannel.register(selector, ops);
    }

    public static void readDataFromSocket(SelectionKey key) throws Exception{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear();

        while((count = socketChannel.read(buffer)) > 0){
            buffer.flip();

            // 你说啥我也说啥
            while(buffer.hasRemaining()){
                socketChannel.write(buffer);
            }

            buffer.clear();
        }

        // 通道已关闭
        if(count < 0){
            socketChannel.close();
        }
    }

    private static void sayHello(SocketChannel channel) throws Exception{
        buffer.clear();
        buffer.put("Hi there !\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
    }
}
