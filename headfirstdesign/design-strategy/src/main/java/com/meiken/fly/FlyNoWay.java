package com.meiken.fly;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
