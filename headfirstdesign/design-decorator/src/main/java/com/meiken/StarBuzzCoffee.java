package com.meiken;

import com.meiken.coffee.*;
import com.meiken.coffee.beverage.Beverage;
import com.meiken.coffee.beverage.DarkRoast;
import com.meiken.coffee.beverage.Espresso;

import java.util.HashSet;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ " + beverage.coast());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $ " + beverage1.coast());
    }
}
