package com.meiken.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheMain {

    public static void main(String[] args) throws InterruptedException {
        cacheBaseUse();

    }


    public static void cacheBaseUse() throws InterruptedException {
        Cache<String,String> cache = CacheBuilder
                .newBuilder()
                .maximumSize(100)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build();

        cache.put("a","1");
        System.out.println(cache.getIfPresent("a"));
        Thread.sleep(3000);
        System.out.println(cache.getIfPresent("a"));
        Thread.sleep(5000);
        System.out.println(cache.getIfPresent("a"));
    }
}
