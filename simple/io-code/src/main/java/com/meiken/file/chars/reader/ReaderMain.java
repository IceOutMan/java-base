package com.meiken.file.chars.reader;


import java.io.*;

/**
 * @Author glf
 * @Date 2021/1/16
 */
public class ReaderMain {
    public static void main(String[] args) throws IOException {
        readOneByOne();
        readBuffer();
    }
    public static void readOneByOne() throws IOException{
        System.out.println("READ ONE BY ONE");
        File file = new File("test.txt");
        InputStreamReader reader = new FileReader(file);
        while(true){
            int c = reader.read();
            if(c == -1){
                break;
            }
            System.out.println((char)c);
        }
        reader.close();
    }

    public static void readBuffer() throws IOException{
        System.out.println("READ BUFFER");
        File file = new File("test.txt");
        InputStreamReader reader = new FileReader(file);
        char[] buffer = new char[5];
        while (true){
            int result = reader.read(buffer, 0,5);
            if(result == -1){
                break;
            }
            System.out.println(new String(buffer));
        }
        reader.close();
    }
}
