package com.meiken.file;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class ReadMain {
    public static void main(String[] args) throws IOException {
        readByte();
        readChar();
    }


    public static void readChar() throws IOException {
        String filePath = "guavalearn/src/main/resources/testfile/TEXT.txt";

        CharSource charSource = Files.asCharSource(new File(filePath), Charsets.UTF_8);
        ImmutableList<String> lines = charSource.readLines();
        System.out.println(lines);
    }

    public static void readByte() throws IOException {
        String filePath = "guavalearn/src/main/resources/testfile/TEXT.txt";

        ByteSource byteSource = Files.asByteSource(new File(filePath));
        byte[] read = byteSource.read();
        System.out.println(new String(read));
    }
}
