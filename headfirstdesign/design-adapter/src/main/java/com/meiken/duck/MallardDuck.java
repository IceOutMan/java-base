package com.meiken.duck;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
