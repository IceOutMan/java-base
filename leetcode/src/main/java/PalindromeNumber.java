/**
 * @Author glf
 * @Date 2021/3/17
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(100111));
    }

    public static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int d = 1;//divisor
        //x最高位
        while(x/d >= 10){
            d  = d*10;
        }
        // 首尾两端取值
        while(x > 0){
            int first = x / d;
            int last = x % 10;
            if(first != last){
                return false;
            }
            x = x % d /10;
            d = d / 100;
        }
        return true;
    }
}
