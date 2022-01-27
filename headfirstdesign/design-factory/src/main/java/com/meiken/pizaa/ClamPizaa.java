package com.meiken.pizaa;

public class ClamPizaa implements Pizaa {
    @Override
    public String getName() {
        return "ClamPizaa";
    }

    @Override
    public void cost() {
        System.out.println("Clam Pizaa Cost 2");
    }
}
