package com.meiken;

public class DefaultLogger implements Logger{
    @Override
    public void info(String log) {
        System.out.println("this is meiken log service default impl : " + log);
    }
}
