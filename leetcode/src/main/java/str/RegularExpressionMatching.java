package str;

import java.util.concurrent.TransferQueue;

/**
 * @Author glf
 * @Date 2021/3/16
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("", "a*"));
    }

    // m行 n列
    public static boolean isMatch(String s,String p){
        s = "#"+s;
        p = "#"+p;
        int m = s.length();
        int n = p.length();
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        boolean f[][] = new boolean[m][n];
        //初始化
        f[0][0] = true;
        for(int index=1;index<m;index++){
            f[index][0] = false;
        }
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(P[j] == '*'){
                    // S[i] != P[j-1]  丢弃 x* f[i][j] f[i][j-2]
                    //S[i] == P[j-1]    丢弃S的一个 f[i-1][j] or 丢弃 x* f[i][j-2]
                    if(matches(s,p,i,j-1)){
                        f[i][j] = f[i-1][j] || f[i][j-2];
                    }else{
                        f[i][j] = f[i][j-2];
                    }
                }else{
                    if(matches(s,p,i,j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }
        return f[m-1][n-1];
    }


    public static boolean matches(String s, String p, int i, int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j) == '.'){
            return true;
        }
        return s.charAt(i) == p.charAt(j);
    }
}
