package com.meiken.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SocketChannelAccept {
    public static final String GREETING = "Hello I must be going.\r\n";

    public static void main(String[] args) throws Exception {

        int port = 1234;

        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes(StandardCharsets.UTF_8));
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));

        SocketChannel sc = ssc.accept();

        if(sc == null){
            Thread.sleep(2000);
        }else {
            System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());
            buffer.rewind();
            sc.write(buffer);
            sc.close();
        }


    }

}
