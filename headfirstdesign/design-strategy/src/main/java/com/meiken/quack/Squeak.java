package com.meiken.quack;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
