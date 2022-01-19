package com.meiken.coffee;

import com.meiken.coffee.beverage.Beverage;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();

}
