package str;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        int[] nexts = getNexts("ababc".toCharArray(), 5);
        System.out.println(nexts);
    }

    public static int kmpStrStr(String haystack, String needle){
        if(needle.length() == 0){return 0;}

        //求next 数组
        int next[] = getNexts(needle.toCharArray(),needle.length());

        int j = 0;
        for(int i=0;i<haystack.length();i++){

            // 一直找 和 arr[i] 相等的 j,如果 j==0 也没匹配就寻找下一个
            while(j >0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1] + 1;
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return i-j+1;
            }
        }

        return  -1;

    }

    public static int[] getNexts(char[] needle, int m){
        int next[] = new int[m];
        next[0] = -1;
        for(int i=1;i<m;i++){

            //遍历寻找上一个最长后缀
            int index = next[i-1];
            while(index != -1 && needle[index+1] != needle[i]){
                index = next[index];
            }
            if(needle[index+1] == needle[i]){
                next[i] = index +1;
            }else{
                next[i] = -1;
            }

            // 当 index==-1 并且 arr[index+1] != arr[i]  -> arr[i] = -1
        }
        return next;
    }

    public static int strStr(String haystack, String needle){
        if(haystack == null || needle == null){
            return  -1;
        }
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        int hLength = haystack.length();
        int nLength = needle.length();
        for(int i=0;i<hLength;i++){

            int start = i;
            boolean flag = true;
            for(int j=0;j<nLength;j++){
                if(start >= hLength || haystack.charAt(start) != needle.charAt(j)){
                    flag = false;
                    break;
                }
                start++;
            }
            if(flag == true){
                return i;
            }
        }
        return -1;
    }
}
