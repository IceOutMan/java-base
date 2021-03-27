package com.meiken.quack;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
