package com.meiken.duck;


import com.meiken.fly.FlyBehavior;
import com.meiken.quack.QuackBehavior;

/**
 * @Author glf
 * @Date 2020/6/16
 */
public abstract class Duck  {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    public void setFlyBehavior(FlyBehavior fb){
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float，even decoys!");
    }

}
