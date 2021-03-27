package com.meiken.duck;

import com.meiken.duck.Duck;
import com.meiken.fly.FlyWithWings;
import com.meiken.quack.Quack;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
