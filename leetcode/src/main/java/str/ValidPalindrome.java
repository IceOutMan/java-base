package str;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a _canal: Panama"));
    }

    public static boolean isPalindrome(String s){
        s = s.toLowerCase().replaceAll("\\W", "").replaceAll("_", "");
        System.out.println(s);
        if(s == null ){
            return false;
        }

        int start = 0,end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
