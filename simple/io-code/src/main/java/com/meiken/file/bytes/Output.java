package com.meiken.file.bytes;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author glf
 * @Date 2021/1/16
 */
public class Output {
    public static void main(String[] args) throws IOException {
        writeOneByOne();
        writeBuffer();
    }

    public static void writeOneByOne() throws IOException {
        System.out.println("WRITE ONE BY ONE");
        File file = new File("test.txt");
        OutputStream os = new FileOutputStream(file,true);

        String content = "Hi my name is writeOneByone\n";
        byte[] bytes = content.getBytes();

        for(byte b : bytes){
            os.write(b);
        }
        os.flush();
    }

    public static void writeBuffer() throws IOException{
        System.out.println("WRITE BUFFER");
        File file = new File("test.txt");
        OutputStream os = new FileOutputStream(file,true);

        String content = "Hi my name is writeBuffer";
        byte[] bytes = content.getBytes();
        os.write(bytes,0,bytes.length);
        os.flush();
    }
}
