package com.com.meiken;

/**
 * @Author glf
 * @Date 2020/11/16
 */
public class GumballMachine {

    private String location;

    private int count;

    private String state;

    public GumballMachine(String location,int count){
        this.location = location;
        this.count = count;
    }

    public String getLocation(){
        return location;
    }

    public int getCount(){
        return count;
    }

    public String getState(){
        return state;
    }

    //其他方法
}
