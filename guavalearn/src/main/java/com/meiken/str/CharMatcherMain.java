package com.meiken.str;

import com.google.common.base.CharMatcher;

public class CharMatcherMain {
    public static void main(String[] args) {
        System.out.println(CharMatcher.is('a').matchesAllOf("aaa"));
        System.out.println(CharMatcher.is('s').indexIn("01ssssss"));
        System.out.println(CharMatcher.is('s').countIn("sssssssss"));
        System.out.println(CharMatcher.is('a').retainFrom("bazaar"));
        System.out.println(CharMatcher.is('a').removeFrom("bazaar"));
    }
}
