package com.meiken.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

public class PipeTest {
    public static void main(String[] args) throws IOException {
        // Wrap a channel around stdout
        WritableByteChannel out = Channels.newChannel(System.out);

        ReadableByteChannel workerReadableChannel = startWorker(10);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        while(workerReadableChannel.read(buffer) >= 0){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    /**
     * 创建一个PIPE ， 使用PIPE的WritableByteChannel 写数据，使用 ReadableByteChannel就可以获取数据
     * @param reps
     * @return
     * @throws IOException
     */
    private static ReadableByteChannel startWorker(int reps) throws IOException {
        Pipe pipe = Pipe.open();
        Worker worker = new Worker(pipe.sink(), reps);
        worker.start();
        return (pipe.source());
    }

    private static class Worker extends Thread{
        WritableByteChannel channel;
        private int reps;
        Worker(WritableByteChannel channel, int reps){
            this.channel = channel;
            this.reps = reps;
        }

        @Override
        public void run() {
            super.run();
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            try {
                for (int i = 0; i < this.reps; i++) {
                    doSomeWork(buffer);
                    while(channel.write(buffer)>0){
                        // empty
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private String[] products = {
                "No good deed goes unpunished",
                "To be, or what?",
                "No matter where you go, there you are",
                "Just say \"Yo\"",
                "My karma ran over my dogma"
        };

        private Random rand = new Random();
        private void doSomeWork(ByteBuffer buffer){
            int product = rand.nextInt(products.length);
            buffer.clear();
            buffer.put(products[product].getBytes());
            buffer.put("\r\n".getBytes());
            buffer.flip();
        }
    }

}
