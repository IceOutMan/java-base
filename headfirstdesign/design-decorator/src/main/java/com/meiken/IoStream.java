package com.meiken;

import com.meiken.iostream.LowCaseInputStream;

import java.io.*;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class IoStream {
    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = new LowCaseInputStream(new BufferedInputStream(new FileInputStream(new File("test.txt"))));
        while ((c = in.read()) >= 0){
            System.out.println((char)c);
        }
        in.close();
    }
}
