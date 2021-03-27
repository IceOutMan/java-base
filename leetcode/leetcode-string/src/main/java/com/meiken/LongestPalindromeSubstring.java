package com.meiken;

/**
 * @Author glf
 * @Date 2020/5/7
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome1("ccc"));
//        System.out.println(longestPalindrome2("ccc"));
//        System.out.println(longestPalindrome3("ccc"));

        System.out.println(longestPalindrome4("ccc"));

    }


    public static String longestPalindrome4(String s){

        char[] S = s.toCharArray();
        StringBuilder res = new StringBuilder("$#");
        for (int i=0;i<S.length;i++){
            res.append(S[i]).append("#");
        }

        S = res.toString().toCharArray();
        int[] p = new int[S.length];

        int mi = 0,right = 1;
        int maxPoint = 0,maxLength = 0;

        for(int i=1;i<S.length;i++){
            p[i] = i < right ? Math.min(p[2*mi-i],right-i) : 1;

            while(i+p[i] < S.length && S[i+p[i]] == S[i-p[i]]){
                p[i]++;
            }

            if(i+p[i] > right){
                mi = i;
                right = i+p[i];
            }

            if(p[i]>maxLength){
                maxPoint = i;
                maxLength = p[i];
            }
        }

        return s.substring((maxPoint-maxLength)/2, (maxPoint-maxLength)/2 + maxLength-1);


    }

    public static String longestPalindrome3(String s){
        char[] S = s.toCharArray();
        int sLength = S.length;

        boolean[][] f = new boolean[sLength][sLength];

        int maxLength = 1;
        int start = 0;
        for(int j=0;j<sLength;j++){

            for(int i=0;i<=j;i++){
                if(i==j){
                    f[i][j]=true;
                }else if(j == i+1){
                    f[i][j] = S[i] == S[j];
                }else if(j > i+1){
                    f[i][j] = (S[i]==S[j] && f[i+1][j-1]);
                }

                //
                if(f[i][j] && (j-i + 1 >maxLength )){
                    maxLength = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }


    public static String longestPalindrome1(String s) {
        // write your code here
        char[] S = s.toCharArray();
        int sLength = S.length;

        int maxLength = 1;
        String resultSbuString = "";



        for(int i=0;i<sLength;i++){

            int l = -1;
            int r = Integer.MAX_VALUE;


            //偶数型
            if(i + 1< sLength  && S[i] == S[i+1]) {

                int tempLength  = 0;
                String  tempSubStr = "";

                l = i - 1;
                r = i + 2;
                tempLength = 2;
                tempSubStr = s.substring(i,i+2);


                while(l >= 0 && r < sLength && S[l] == S[r]){
                    tempLength ++;
                    tempSubStr = s.substring(l,r+1 );

                    l--;
                    r++;
                }

                if(resultSbuString.length() < tempSubStr.length()){
                    maxLength = tempLength;
                    resultSbuString = tempSubStr;
                }
            }

            //奇数型
            if(i < sLength ){

                int tempLength  = 0;
                String  tempSubStr = "";

                l = i-1;
                r = i+1;
                tempLength  = 1;
                tempSubStr = s.substring(i,i+1);


                while(l >= 0 && r < sLength && S[l] == S[r]){
                    tempLength ++;
                    tempSubStr = s.substring(l,r+1 );

                    l--;
                    r++;
                }

                if(resultSbuString.length() < tempSubStr.length()){
                    maxLength = tempLength;
                    resultSbuString = tempSubStr;
                }
            }
        }
        return resultSbuString;
    }


    public static String longestPalindrome2(String s){
        //其实就是递归 然后加上记录
        char[] S = s.toCharArray();
        int sLength = S.length;
        String[][] f = new String[sLength ][sLength ];

        return generateLongestPalindromeSubString(f,0,sLength-1, s, S);

    }

    private static String generateLongestPalindromeSubString(String[][] f,int i,int j,String s,char[] S){

        if(i<0 || j>=s.length() || i>j){
            f[i][j] = "";
            return f[i][j];
        }

        if(f[i][j] != null && !"".equals(f[i][j])){
            return f[i][j];
        }


        if(i==j){
            f[i][j] = s.substring(i,i+1);
            return f[i][j];
        }else if(S[i] == S[j] &&  s.substring(i+1,j).equals(generateLongestPalindromeSubString(f,i+1,j-1,s,S))){
            f[i][j] = s.substring(i,j+1);
            return f[i][j];
        }else {
            String s1 = generateLongestPalindromeSubString(f,i+1,j-1, s, S);
            String s2 = generateLongestPalindromeSubString(f,i,j-1, s, S);
            String s3 = generateLongestPalindromeSubString(f,i+1,j, s, S);

            String maxS = s1;
            if(maxS.length()<s2.length()){
                maxS = s2;
            }
            if(maxS.length() < s3.length()){
                maxS = s3;
            }

            f[i][j] = maxS;

            return f[i][j];
        }

    }



}
