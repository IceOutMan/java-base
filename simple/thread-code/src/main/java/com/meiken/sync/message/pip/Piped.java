package com.meiken.sync.message.pip;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 输入流和输出流进行连接，否则会抛出IOException
        out.connect(in);
        // 开启读线程
        new Thread(new Print(in), "PrintThread").start();

        // 管道中写数据
        int received = 0;
        try{
            while((received = System.in.read()) != -1){
                out.write(received);
            }
        }catch (Exception e){

        }finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int received = 0;
            try{
                while ((received = in.read()) != -1){
                    System.out.print((char) received);
                }
            }catch (Exception e){

            }

        }
    }
}

