package str;

/**
 * @Author glf
 * @Date 2021/3/16
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }

        int length = 0;
        String firstStr = strs[0];
        for(int i = 0;i < firstStr.length(); i++){
            char indexChar = firstStr.charAt(i);

            boolean flag = true;
            for(int j =1;j<strs.length; j++){
                if(strs[j].length() <= length || strs[j].charAt(length) != indexChar ){
                    flag = false;
                    break;
                }
            }

            if(flag){
                length++;
            }else{
                break;
            }
        }
        return firstStr.substring(0,length);
    }
}
