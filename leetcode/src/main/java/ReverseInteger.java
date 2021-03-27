import javax.print.DocFlavor;

/**
 * @Author glf
 * @Date 2021/3/17
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(0));
    }
    public static int reverse(int x){
        int sum= 0;

        while(x!=0){
            int num = x % 10;
            x = x / 10;

            if(sum >Integer.MAX_VALUE / 10 ||
                    ( (sum == Integer.MAX_VALUE /10)  && (num >Integer.MAX_VALUE % 10) )){
                return 0;
            }
            if(sum < Integer.MIN_VALUE / 10 ||
                    ( (sum == Integer.MIN_VALUE /10)  && (num <Integer.MIN_VALUE % 10) )){
                return 0;
            }
            sum = sum * 10 + num;
        }
        return   sum;
    }
}
