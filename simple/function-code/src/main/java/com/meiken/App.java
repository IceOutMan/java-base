package com.meiken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //就像是创建了一个接口的实现类，为了去实现那个抽象方法
        MessageCallback callback = message -> System.out.println(message);
        functionTest(callback);
    }

    public static void functionTest(MessageCallback callback){
        callback.say("Callback say");
    }
}