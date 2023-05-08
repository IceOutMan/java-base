package com.meiken;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class FileReadTest {

    public static void main(String[] args) throws IOException {
        String path = "/Users/xmly/IdeaProjects/java-base/simple/test/src/main/java/com/meiken/config/config";
        File configFile = new File(path);

        FileInputStream in = new FileInputStream(configFile);

        Properties properties = new Properties();
        properties.load(in);

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            String key = entry.getKey().toString().trim();
            String value = entry.getValue().toString().trim();
            System.out.println("key: " + key + ", value: " + value);
        }
    }
}
