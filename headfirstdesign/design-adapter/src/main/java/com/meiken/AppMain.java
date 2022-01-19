package com.meiken;

import com.meiken.duck.MallardDuck;
import com.meiken.turkey.WildTurkey;
import com.meiken.duck.Duck;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class AppMain {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("The Turkey says.....");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        mallardDuck.quack();
        mallardDuck.fly();

        System.out.println("\nThe TurkeyAdapter says....");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
