package com.meiken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args)
    {
        MeikenConfig config = new MeikenConfig.Builder().name("张三").age(2).build();
        System.out.println(config.getContent());

    }
}
