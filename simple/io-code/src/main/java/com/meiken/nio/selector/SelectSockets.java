package com.meiken.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectSockets {
    public static int PORT_NUMBER = 1234;

    public static void main(String[] args) throws Exception {
         new SelectSockets().go(args);
    }

    public void go(String[] argv) throws Exception {
        int port = PORT_NUMBER;
        if (argv.length > 0) {
            port = Integer.parseInt(argv[0]);
        }
        System.out.println("Listening on port" + port);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();

        Selector selector = Selector.open();

        serverSocket.bind(new InetSocketAddress(port));

        // set nonblocking mode for listening socket
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
           int n = selector.select();
           if(n == 0){
               continue;
           }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

           while(iterator.hasNext()){
               SelectionKey key = iterator.next();

               if(key.isAcceptable()){
                   ServerSocketChannel server = (ServerSocketChannel) key.channel();
                   SocketChannel socketChannel = server.accept();

                   registerChannel(selector, socketChannel, SelectionKey.OP_READ);

                   sayHello(socketChannel);
               }

               if(key.isReadable()){
                   readDataFromSocket(key);
               }

               iterator.remove();
           }

        }

    }

    public void registerChannel(Selector selector, SocketChannel socketChannel, int ops) throws Exception{
        if(socketChannel == null){
            return;
        }

        // set the new channel nonblocking
        socketChannel.configureBlocking(false);

        socketChannel.register(selector, ops);
    }
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public void readDataFromSocket(SelectionKey key) throws Exception{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear();

        while((count = socketChannel.read(buffer)) > 0){
            buffer.flip();

            while(buffer.hasRemaining()){
                socketChannel.write(buffer);
            }

            buffer.clear();
        }

        if(count < 0){
            socketChannel.close();
        }
    }

    private void sayHello(SocketChannel channel) throws Exception{
        buffer.clear();
        buffer.put("Hi there !\r\n".getBytes());
        buffer.flip();

        channel.write(buffer);
    }

}
