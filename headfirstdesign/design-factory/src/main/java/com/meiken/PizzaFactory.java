package com.meiken;

import com.meiken.pizaa.ClamPizaa;
import com.meiken.pizaa.Pizaa;
import com.meiken.pizaa.VagglePizaa;

public class PizzaFactory {

    public Pizaa createPizaa(String type) throws Exception {
        if("Clam".equals(type)){
            return new ClamPizaa();
        }else if("Vaggle".equals(type)){
            return new VagglePizaa();
        }
        throw new Exception("Type Error");

    }
}
