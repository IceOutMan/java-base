package com.meiken.coffee;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double coast() {
        return 0.2 + beverage.coast();
    }
}
