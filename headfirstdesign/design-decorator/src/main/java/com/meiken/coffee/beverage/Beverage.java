package com.meiken.coffee.beverage;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public abstract class Beverage {
    public String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double coast();
}
