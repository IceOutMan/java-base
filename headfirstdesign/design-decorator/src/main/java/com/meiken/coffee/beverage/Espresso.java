package com.meiken.coffee.beverage;

import com.meiken.coffee.beverage.Beverage;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }
    @Override
    public double coast() {
        return 1.99;
    }
}
