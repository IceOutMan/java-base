package com.meiken;

import com.meiken.duck.Duck;
import com.meiken.turkey.Turkey;

/**
 * @Author glf
 * @Date 2021/1/18
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for(int i=0; i<5; i++){
            turkey.fly();
        }

    }
}
