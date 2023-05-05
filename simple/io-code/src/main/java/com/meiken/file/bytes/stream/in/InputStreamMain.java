package com.meiken.file.bytes.stream.in;

import java.io.*;

/**
 * @Author glf
 * @Date 2021/1/16
 */
public class InputStreamMain {
    public static void main(String[] args) throws IOException {

        readOneByOne();
        readBuffered();
    }

    public static void readOneByOne() throws IOException {
        System.out.println("READ ONE BY ONE");
        File file = new File("test.txt");
        InputStream in  = new FileInputStream(file);

        while(true){
            int c = in.read();
            if(c == -1){
                break;
            }
            System.out.println((char)c);
            if (c == '\n'){
                System.out.println("this is -n");
            }
        }
        System.out.println("END");
        in.close();
    }
    public static void readBuffered() throws IOException{
        System.out.println("READ BUFFERED");
        File file = new File("test.txt");
        InputStream in = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        while (true){
            int result = in.read(buffer);
            if(result == -1 ){
                break;
            }
            System.out.println(new String(buffer));
        }
        in.close();
    }
}
