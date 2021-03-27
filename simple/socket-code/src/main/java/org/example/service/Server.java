package org.example.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author glf
 * @Date 2021/1/16
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("server is running....");

            for (;;){
                Socket socket = serverSocket.accept();//server会等待在 accept方法上
                System.out.println("connected from " + socket.getRemoteSocketAddress());

                //得到了一个连接后，开启一个线程处理这个连接
                HandlerThread handlerThread = new HandlerThread(socket);
                handlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class HandlerThread extends Thread{

    Socket socket;

    public HandlerThread(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        super.run();

        try(InputStream input = socket.getInputStream()){
          try(OutputStream output = socket.getOutputStream()){
              handle(input,output);
          }
        } catch (IOException e) {
            try{
                this.socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8 ));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,StandardCharsets.UTF_8));
        //处理 HTTP请求
        boolean requestOk = false;
        String first = reader.readLine();
        if(first.startsWith("GET / HTTP/1.")){
            requestOk = true;
        }
        for(;;){
            String header = reader.readLine();
            if(header.isEmpty()){ //读取到空行，HTTP Header 读取完毕
                break;
            }
            System.out.println(header);
        }

        System.out.println(requestOk ? "Response OK" : "Response Error");
        if (!requestOk) {
            //发送错误响应
            writer.write("HTTP/1.0 404 Not Fount\r\n");
            writer.write("Content-Length:0\r\n");
            writer.write("\r\n");
            writer.flush();
        }else{
            //发送成功数据
            String data = "<html><body><h1>Hello, world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Connection:close\r\n");
            writer.write("Content-Type:text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");
            writer.write("\r\n");
            writer.write(data);
            writer.flush();
        }

    }
}
