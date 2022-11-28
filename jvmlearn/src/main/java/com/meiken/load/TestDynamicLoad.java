package com.meiken.load;

public class TestDynamicLoad {
    static {
        System.out.println("==========Load TestDynamicLoad");
    }
    public static void main(String[] args) {
        new A();
        System.out.println("==========Load Test");
        B b = null;

    }

}

class A{
    static {
        System.out.println("==========Load A");
    }
    public A(){
        System.out.println("=========Initial A");
    }

}

class B{
    static {
        System.out.println("==========Load B");
    }
    public B(){
        System.out.println("=========Initial B");
    }

}

