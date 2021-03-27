package com.meiken.fly;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Im flying!");
    }
}
