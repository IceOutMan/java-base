package com.meiken.base.server;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatServer extends ChannelDuplexHandler {
    private int readIdleTimes = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // TODO: 触发心跳超时事件
        IdleStateEvent event = (IdleStateEvent) evt;
        String eventType = null;
        switch (event.state()){
            case READER_IDLE:
                eventType = "读空闲";
                readIdleTimes++; // 读空闲超时次数
                break;
            case WRITER_IDLE:
                eventType = "写空闲";
                break;
            case ALL_IDLE:
                eventType = "读写空闲";
                break;

        }
        if(readIdleTimes > 3){
            System.out.println("读空闲超过3次，关闭连接");
            ctx.channel().writeAndFlush("idle close");
            ctx.channel().close();
        }
    }
}
