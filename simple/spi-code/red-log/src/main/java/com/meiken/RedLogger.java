package com.meiken;

public class RedLogger implements Logger{

    @Override
    public void info(String log) {
        System.out.println("this is red logger : " + log);
    }
}
