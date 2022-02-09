package com.meiken.implement.substring;

import java.math.BigInteger;

/**
 * Rabin-Karp 算法，巧妙的Hash和计算方式
 * 这里假设匹配串和模式串都是26个字符，使用26进制的方式不会有hash冲突
 *
 * 时间复杂度分析：
 */
public class RK {
    public static void main(String[] args) {
        String haystack = "abdefckefg";
        String needle = "def";
        System.out.println(subString(haystack, needle));
    }


    public static int subString(String haystack, String needle){
        if(haystack == null || needle == null){
            return -1;
        }
        int hLength = haystack.length();
        int nLength = needle.length();

        // 1. 构造 指数 数组
        BigInteger[] powerArray = getPowerArray(nLength);

        /**
         * a b e f g
         *       t f
         */
        // 2. 计算匹配串中的 Hash 值
        BigInteger[] hashValueArray = getHashValueArray(haystack, needle, powerArray);

        // 3. 模式串的hash值
        BigInteger needleHashValue = getNeedleHashValue(needle, powerArray);

        // 4. 匹配
        for(int index=0; index< hLength - nLength + 1; index++){
            BigInteger bigInteger = hashValueArray[index];
            if (bigInteger.equals(needleHashValue)) {
                return index;
            }
        }
        return -1;
    }

    // 获取模式串的 hash 值
    private static BigInteger getNeedleHashValue(String needle, BigInteger[] powerArray) {
        int nLength = needle.length();
        BigInteger needleHashValue = new BigInteger("0");
        for(int index = 0; index < nLength; index++){
            BigInteger power = powerArray[nLength - index - 1];
            int charInt = getCharValue(needle.charAt(index));
            BigInteger charValue = new BigInteger(String.valueOf(charInt));

            needleHashValue = needleHashValue.add(charValue.multiply(power));
        }

        return needleHashValue;
    }

    // 时间复杂度是 n
    private static BigInteger[] getHashValueArray(String haystack, String needle , BigInteger[] powerArray){
        int hLength = haystack.length();
        int nLength = needle.length();

        int hashArrayLength = hLength - nLength + 1;
        /**
         * a b e f g
         *       t f
         */
        BigInteger[] hashValueArray = new BigInteger[hashArrayLength];

        // 第一个需要单独计算
        hashValueArray[0] = new BigInteger("0");
        for(int j=0;j<nLength;j++){
            int charValue = getCharValue(haystack.charAt(j));
            BigInteger power = powerArray[nLength-j-1];
            hashValueArray[0] = power.multiply(new BigInteger(String.valueOf(charValue))).add(hashValueArray[0]);
        }

        for(int index=1; index< hashArrayLength;index++){
            int subtractionChar = getCharValue(haystack.charAt(index-1));
            int addChar = getCharValue(haystack.charAt(index + nLength-1));

            BigInteger subtractionValue = powerArray[nLength-1].multiply(new BigInteger(String.valueOf(subtractionChar)));
            BigInteger addValue = new BigInteger(String.valueOf(addChar));
            BigInteger lastHashValue = hashValueArray[index-1];

            BigInteger indexHashValue = lastHashValue.subtract(subtractionValue).multiply(powerArray[1]).add(addValue);
            hashValueArray[index] = indexHashValue;
        }
        return hashValueArray;
    }

    private static int getCharValue(char c){
        return c - 'a' ;
    }

    // 时间复杂度是 n
    private static BigInteger[] getPowerArray(int needleLength){
        BigInteger base = new BigInteger("26");
        BigInteger[] powerArray =new BigInteger[needleLength];
        powerArray[0] = new BigInteger("1");

        for(int i=1; i<needleLength;i++){
            powerArray[i] = powerArray[i-1].multiply(base);
        }
        return powerArray;
    }

}
