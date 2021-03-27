package org.example.file;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author glf
 * @Date 2021/1/13
 */
public class IoMain {

    public static void main(String[] args) throws IOException {
       read();
       write();
    }

    public static void read() throws IOException {

//        String filePath = IoMain.class.getResource("/testfile/TEXT.txt").getPath();
        String filePath = "guavalearn/src/main/resources/testfile/TEXT.txt";

        System.out.println(filePath);
        ByteSource byteSource = Files.asByteSource(new File(filePath));
        byte[] read = byteSource.read();
        System.out.println(new String(read));

        CharSource charSource = Files.asCharSource(new File(filePath), Charsets.UTF_8);
        ImmutableList<String> lines = charSource.readLines();
        System.out.println(lines);
    }


    public static void write() throws IOException {
        String filePath = "guavalearn/src/main/resources/testfile/TEXT.txt";

        String content = "His name is heiehi\nhis name is hhaha\n";
        System.out.println(filePath);

        ByteSink byteSink = Files.asByteSink(new File(filePath),FileWriteMode.APPEND);
        byteSink.write(content.getBytes());

        CharSink charSink = Files.asCharSink(new File(filePath), Charsets.UTF_8, FileWriteMode.APPEND);
        charSink.write(content);
        List<String> lines = Lists.newArrayList("1 Line","2 Line","3 Line","4 Line");
        charSink.writeLines(lines);

    }
}
