package com.meiken.quack;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
