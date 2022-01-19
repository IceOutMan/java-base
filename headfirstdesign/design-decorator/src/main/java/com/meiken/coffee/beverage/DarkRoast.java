package com.meiken.coffee.beverage;

import com.meiken.coffee.beverage.Beverage;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
       description = "Dark Roast";
    }

    @Override
    public double coast() {
        return 2.4;
    }
}
