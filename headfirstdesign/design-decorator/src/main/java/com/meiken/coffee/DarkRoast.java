package com.meiken.coffee;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class DarkRoast extends Beverage{
    public DarkRoast() {
       description = "Dark Roast";
    }

    @Override
    public double coast() {
        return 2.4;
    }
}
