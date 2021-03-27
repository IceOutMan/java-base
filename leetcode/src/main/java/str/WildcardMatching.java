package str;

/**
 * @Author glf
 * @Date 2021/3/16
 */
public class WildcardMatching {
    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p){

        s = "#" +s;
        p = "#" +p;

        char[] S = s.toCharArray();
        char[] P = p.toCharArray();

        int m =S.length;
        int n = P.length;
        boolean[][] f = new boolean[m][n];

        f[0][0] = true;

        //初始化 S为空的第一行匹配结果
        for(int j=1;j<n;j++){
            if(P[j] == '*'){
                f[0][j] = true;
            }else {
                break;
            }
        }

        for(int i=1;i<m;i++){

            for(int j=1;j<n;j++){

                if(P[j] == '*'){
                    // * 可以匹配任意字符穿
                    //f[i][j-1] 不使用 * 是否匹配
                    //f[i-1][j] 使用 * 号是否匹配
                    f[i][j] = f[i][j-1] || f[i-1][j];
                }else if(P[j] == '?' || S[i] == P[j]){
                    f[i][j]  = f[i-1][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

//    public static boolean match(String s,String p,int i, int j){
//        if(p.charAt(j) == '?'){
//            return true;
//        }else if(s.charAt(i) == p.charAt(j)){
//            return true;
//        }
//        return false;
//    }
}
