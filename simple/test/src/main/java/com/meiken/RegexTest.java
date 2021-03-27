package com.meiken;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author glf
 * @Date 2020/8/29
 */
public class RegexTest {

    public static void main(String[] args) {

        String content = "hello,heihei,im here";

        String patternStr = "hei*?";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(content);


        while (matcher.find()){
            System.out.println(matcher.start()+" - "+matcher.group() +" - "+ matcher.end());

//            System.out.println(matcher.start(0)+" - "+matcher.group(0) +" - "+ matcher.end(0));
//            System.out.println(matcher.start(1)+" - "+matcher.group(1) +" - "+ matcher.end(1));
//            System.out.println(matcher.start(2)+" - "+matcher.group(2) +" - "+ matcher.end(2));
//            System.out.println(matcher.start(3)+" - "+matcher.group(3) +" - "+ matcher.end(3));
        }

//        if (matcher.matches()) {
//            System.out.println(matcher.start()+" - "+matcher.group() +" - "+ matcher.end());
//        }
//
//        if (matcher.lookingAt()) {
//            System.out.println(matcher.start()+" - "+matcher.group() +" - "+ matcher.end());
//        }

    }
}
