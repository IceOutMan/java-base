package org.example.chars;

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

    public static void writeOneByOne() throws IOException{
        System.out.println("WRITE ONE BY ONE");
        File file = new File("test.txt");
        OutputStreamWriter write = new FileWriter(file,true);

        String content = "My name is WRITER one by one\n";
        char[] chars = content.toCharArray();

        for(char c : chars){
            write.write(c);
        }
        write.flush();
        write.close();
    }
    public static void writeBuffer() throws IOException{
        System.out.println("WRITE BUFFER");
        File file = new File("test.txt");
        OutputStreamWriter writer = new FileWriter(file,true);

        String content = "My name is WRITER BUFFER\n";
        char[] chars = content.toCharArray();
        writer.write(chars,0,chars.length);
        writer.flush();
        writer.close();
    }
}
