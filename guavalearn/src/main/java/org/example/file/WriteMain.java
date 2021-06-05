package org.example.file;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteMain {

    public static void main(String[] args) throws IOException {
        writeByte();
        writeChar();
    }


    public static void writeByte() throws IOException {
        String filePath = "guavalearn/src/main/resources/testfile/TEXT.txt";

        String content = "His name is heiehi\nhis name is hhaha\n";

        ByteSink byteSink = Files.asByteSink(new File(filePath), FileWriteMode.APPEND);
        byteSink.write(content.getBytes());
    }

    public static void writeChar() throws IOException{
        String filePath = "guavalearn/src/main/resources/testfile/TEXT.txt";

        String content = "His name is heiehi\nhis name is hhaha\n";

        CharSink charSink = Files.asCharSink(new File(filePath), Charsets.UTF_8, FileWriteMode.APPEND);
        charSink.write(content);

        List<String> lines = Lists.newArrayList("1 Line","2 Line","3 Line","4 Line");
        charSink.writeLines(lines);
    }
}
