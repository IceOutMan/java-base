package com.meiken;

public class BlueLogger implements Logger{
    @Override
    public void info(String log) {
        System.out.println("this is blue logger : " + log);
    }
}
