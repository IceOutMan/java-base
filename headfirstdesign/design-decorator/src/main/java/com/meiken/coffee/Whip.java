package com.meiken.coffee;

import com.meiken.coffee.beverage.Beverage;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class Whip extends CondimentDecorator{
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double coast() {
        return 1.1 + beverage.coast();
    }
}
