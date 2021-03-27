package com.meiken;

import com.meiken.duck.Duck;
import com.meiken.duck.MallardDuck;
import com.meiken.duck.ModelDuck;
import com.meiken.fly.FlyRocketPowered;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public class StrategyTest {
    public static void main(String[] args) {
        Duck  duck = new MallardDuck();

        duck.performFly();
        duck.performQuack();


        Duck model = new ModelDuck();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
