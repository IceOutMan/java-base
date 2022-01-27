package com.meiken.pizaa;

public class VagglePizaa implements Pizaa{
    @Override
    public String getName() {
        return "Vaggle Pizza";
    }

    @Override
    public void cost() {
        System.out.println("Vaggle Pizza Cost:1");
    }
}
