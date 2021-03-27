package com.meiken.duck;

import com.meiken.fly.FlyNoWay;
import com.meiken.quack.Quack;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
