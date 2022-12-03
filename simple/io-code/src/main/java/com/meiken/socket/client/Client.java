package com.meiken.socket.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author glf
 * @Date 2021/1/16
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            InputStream input  = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8 ));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,StandardCharsets.UTF_8));

            String content = "GET / HTTP/1.1\r\nHost:www.sina.com.cn\r\n\n";
            writer.write(content);
            writer.flush();

            Thread.sleep(1000);
            for (;;){
                if(reader.readLine().isEmpty()){
                    break;
                }
                String line = reader.readLine();
                System.out.println(line);
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
