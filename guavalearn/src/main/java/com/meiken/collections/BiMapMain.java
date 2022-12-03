package com.meiken.collections;

import com.google.common.collect.HashBiMap;

public class BiMapMain {

    public static void main(String[] args) {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("name","email");
        biMap.put("zs","email.zs");
        biMap.put("ls","email.ls");

        System.out.println(biMap.keySet());
        System.out.println(biMap.values());

        System.out.println(biMap.get("lisi"));
        System.out.println(biMap.inverse().get("lisi.com"));

        System.out.println(biMap);
        System.out.println(biMap.inverse());
        System.out.println(biMap.inverse().inverse());

    }
}
