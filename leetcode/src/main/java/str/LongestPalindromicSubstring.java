package str;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        System.out.println(babad);
    }

    public static String longestPalindrome(String s){
        char[] charArr = s.toCharArray();
        int length = charArr.length;

        boolean f[][] = new boolean[length][length];

        int maxLen = 0;
        int index = 0;
        for(int j=0;j<length;j++){
            for(int i=0;i<=j;i++){
                // i == j -> f[i][j] true
                if(i == j){
                    f[i][j] = true;
                }else if(i+1 == j){
                    f[i][j] = charArr[i] == charArr[j];
                } else if(i+1 < j){
                    f[i][j] = (f[i+1][j-1] && charArr[i]==charArr[j]);
                }

                //check maxLen
                if(f[i][j] && (j-i+1)>maxLen){
                    maxLen = j-i+1;
                    index = i;
                }
            }
        }

        return s.substring(index,index + maxLen);
    }
}
