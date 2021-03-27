package str;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String s){
        char[] numChars = s.toCharArray();

        int num = 0;
        int sign = 1;
        int index = 0;

        while(index < numChars.length && numChars[index] == ' ' ){
            index++;
        }

        if(index < numChars.length && numChars[index] == '-'){
            sign = -1;
            index++;
        }else if(index < numChars.length && numChars[index] == '+'){
            sign = 1;
            index++;
        }
        for(;index<numChars.length;index++){
            if(numChars[index]<'0' || numChars[index] > '9'){
                break;
            }
            if(num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && (numChars[index] - '0') > Integer.MAX_VALUE % 10)){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + numChars[index] - '0';
        }

        return sign * num;
    }
}
