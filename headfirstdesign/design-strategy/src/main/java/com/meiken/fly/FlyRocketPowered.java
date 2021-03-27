package com.meiken.fly;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class FlyRocketPowered implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}