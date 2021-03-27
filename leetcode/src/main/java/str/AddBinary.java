package str;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }

    public static String addBinary(String a, String b){
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int maxLength = aChars.length > bChars.length ? aChars.length : bChars.length;

        String result = "";
        int carry = 0;
        int aIndex = aChars.length -1;
        int bIndex = bChars.length - 1;
        for(int i=0;i < maxLength;i++){
            int aVal = aIndex >=0 ? aChars[aIndex]-'0' : 0;
            int bVal = bIndex >=0 ? bChars[bIndex]-'0' : 0;
            int sum = carry + aVal + bVal;
            carry =  sum / 2;
            result = sum % 2 + result;

            aIndex--;
            bIndex--;
        }
        return carry == 1 ? "1"+result : result;
    }
}
