package com.meiken.implement.substring;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * BM（Boyer-Moore）算法
 *
 * 时间复杂度：O(n):
 */
public class BM {

    private final static int SIZE = 256;

    public static void main(String[] args) {

        String temp = "abcdbc";
        char[] tempChars = temp.toCharArray();

        int[] badCharIndex = new int[SIZE];
        generateBadCharIndexArray(tempChars, badCharIndex);
//        generateBadCharIndexArrayByAscii(tempChars, badCharIndex);

        System.out.println(JSON.toJSON(badCharIndex));

    }

    // 使用坏字符
    public static int subStringUseBadChar(String haystack, String needle){
        if(haystack == null || needle == null){
            return -1;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        int[] badCharIndex = new int[SIZE];

        return -1;
    }
    // 使用好后缀
    public static int subStringUseGoodSuffix(String haystack, String needle){


        return -1;
    }

    // 坏字符+好后缀
    public static int subStringUseBadCharAndGoodSuffix(String haystack, String needle){

        return -1;
    }

    // 这里的 badCahrIndex 对应模式传中每个字符作为坏字符，对应的字符在模式串中的下标
    private static void generateBadCharIndexArray(char[] needleChars , int[] badCharIndex){
        HashMap<Character,Integer> badCharIndexMap = new HashMap<>();

        // 初始化
        for(int index =0; index<needleChars.length; index++){
            badCharIndex[index] = -1;
            badCharIndexMap.put(needleChars[index], index);
        }

        for(int index = 0; index < needleChars.length; index++){
            char needleChar = needleChars[index];
            badCharIndex[index] = badCharIndexMap.get(needleChar);
        }
    }

    // 由于是字符，这里使用长度为所有ascii字符数，的数组表示 256
    private static void generateBadCharIndexArrayByAscii(char[] needleChars, int[] badCharIndex){

        // 初始化
        for (int i = 0; i < SIZE; i++) {
            badCharIndex[i] = -1;
        }

        // 赋值
        for (int i = 0; i < needleChars.length; i++) {
            char needleChar = needleChars[i];
            int ascii = needleChar - 'a';
            badCharIndex[ascii] = i;
        }
    }

    // suffix 数组的下标记表示 后缀的长度， suffix[2] = 3, 表示 长度为2的后缀字串，在模式串中存在的下标为3
    // prefix 数组的下标记表示 后缀的长度， 值表示，该后缀字串是否是前缀字串
    private static void generateGoodSuffix(char[] needleChars,int[] suffix, boolean[] prefix){

    }

}
