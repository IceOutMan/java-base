package com.meiken.coffee.beverage;

import com.meiken.coffee.beverage.Beverage;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double coast() {
        return 0.89;
    }
}
