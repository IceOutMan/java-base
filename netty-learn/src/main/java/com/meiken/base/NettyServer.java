package com.meiken.base;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author glf
 * @Date 2022/11/28
 */
public class NettyServer {

    public static void main(String[] args) {
        // 创建两个线程组 bossGroup 和 workerGroup, 含有的子线程 NioEventLoop 的个数默认为 cpu 核数的两倍
        // boosGroup 只是处理连接请求，真正和客户端业务处理，会交给 workerGroup 完成
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建服务器端的启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 使用链式编程 -> 配置参数
            bootstrap.group(boosGroup, workerGroup) // 设置父线程组、子线程组
                    .channel(NioServerSocketChannel.class) // 使用 NioServerSocketChannel 作为服务器的通道实现
                    // 初始化服务器连接队列大小，服务端处理客户端连接请求是顺序处理，所以同一时间只能处理一个客户端连接
                    // 多个客户端同时到来，服务端将不能处理的客户端请求放置到队列中等待处理
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 创建通道初始化对象，设置初始化参数
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 对 workerGroup的SocketChannel 设置处理器
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.out.println("netty server start...");

            // 绑定一个端口并且同步， 生成了一个 ChannelFuture 异步对象， 通过isDone() 等方法可以判断异步时间的执行情况
            // 启动服务器（并绑定端口），bind是异步操作，sync方法是等待异步操作执行完毕
            ChannelFuture cf = bootstrap.bind(9000).sync();
            // 给 cf 注册监听器 ，监听我们关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口9000成功!");
                    } else {
                        System.out.println("监听端口9000失败!");
                    }
                }
            });

            // 对通道关闭监听， closeFuture 是异步操作，监听通道关闭
            // 通过 sync 方法同步等待通道关闭处理完毕，这里会阻塞等待通道关闭完成
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 优雅关闭
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
